package com.fiserv.delivery.service;

import static java.util.Objects.nonNull;

import com.fiserv.delivery.domain.dto.ClienteDto;
import com.fiserv.delivery.domain.dto.EntregaDto;
import com.fiserv.delivery.domain.mapper.EntregaMapper;
import com.fiserv.delivery.domain.request.EntregaRequest;
import com.fiserv.delivery.domain.response.EntregaResponse;
import com.fiserv.delivery.entity.Entrega;
import com.fiserv.delivery.repository.EntregaRepository;
import com.fiserv.delivery.specification.SearchEntregaSpecification;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "transactionManager")
public class EntregaService {

  @Autowired
  private EntregaRepository entregaRepository;

  @Autowired
  private EntregaMapper entregaMapper;

  @Autowired
  private ClienteService clienteService;

  public EntregaDto save(EntregaRequest request){
    entregaValidation(request);

    ClienteDto clienteDto = clienteService.findDtoById(request.getClienteUniqueId());

    EntregaDto entregaDto = new EntregaDto(clienteDto, request.getNumeroPedido(),
        clienteService.formatClienteEndereco(clienteDto));

    return entregaMapper.toDto(entregaRepository.save(entregaMapper.fromDto(entregaDto)));
  }

  public EntregaDto modify(Long entregaId, EntregaRequest request){
    entregaValidation(request);


    EntregaDto entregaDto = entregaMapper.toDto(entregaRepository.findById(entregaId).orElseThrow(() -> new RuntimeException("Entrega nao existe!")));
    ClienteDto clienteDto = clienteService.findDtoById(request.getClienteUniqueId());

    entregaDto.setCliente(clienteDto);
    entregaDto.setNumeroPedido(request.getNumeroPedido());
    entregaDto.setEndereco(clienteService.formatClienteEndereco(clienteDto));

    return entregaMapper.toDto(entregaRepository.save(entregaMapper.fromDto(entregaDto)));
  }

  public List<EntregaDto> findAll(EntregaRequest request, Integer page){
    Page<Entrega> pl = entregaRepository.findAll(new SearchEntregaSpecification(request), PageRequest.of(page, 50));

    List<EntregaDto> entregas = pl.getContent()
        .stream()
        .map(entregaMapper::toDto)
        .collect(Collectors.toList());

    return entregas;
  }

  public EntregaResponse findById(Long entregaId){
    EntregaResponse response = new EntregaResponse();

    EntregaDto entregaDto = entregaMapper.toDto(entregaRepository.findById(entregaId).orElse(null));

    if (nonNull(entregaDto)){
      response.setEntrega(entregaDto);
    }

    return response;
  }

  public void deleteById(Long entregaId){
    entregaRepository.deleteById(entregaId);
  }

  public EntregaDto findDtoById(Long entregaId){
    return entregaMapper.toDto(entregaRepository.findById(entregaId).orElse(null));
  }

  public void entregaValidation(EntregaRequest request){
    if (nonNull(entregaRepository.findByNumeroPedido(request.getNumeroPedido()))){
      throw new RuntimeException("O pedido de numero "+request.getNumeroPedido()+ " ja existe no sistema!");
    }
  }
}
