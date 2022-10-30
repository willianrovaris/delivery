package com.fiserv.delivery.service;

import static java.util.Objects.nonNull;

import com.fiserv.delivery.domain.dto.ClienteDto;
import com.fiserv.delivery.domain.mapper.ClienteMapper;
import com.fiserv.delivery.domain.request.ClienteRequest;
import com.fiserv.delivery.domain.response.ClienteResponse;
import com.fiserv.delivery.entity.Cliente;
import com.fiserv.delivery.repository.ClienteRepository;
import com.fiserv.delivery.specification.SearchClienteSpecification;
import com.fiserv.delivery.util.ValidacaoCPF;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "transactionManager")
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private ClienteMapper clienteMapper;

  public ClienteDto save(ClienteRequest request){
    if ((!ValidacaoCPF.isCPF(request.getCpf())) || (nonNull(clienteRepository.findByCpf(request.getCpf()))) ){
      throw new RuntimeException("CPF Invalido ou ja cadastrado no sistema!");
    }

    ClienteDto clienteDto = new ClienteDto(request.getCpf(), request.getNome(), request.getEndereco(),
        request.getBairro(), request.getCidade(), request.getEstado(), request.getPais());

    return clienteMapper.toDto(clienteRepository.save(clienteMapper.fromDto(clienteDto)));
  }

  public List<ClienteDto> findAll(ClienteRequest request, Integer page){
    Page<Cliente> pl = clienteRepository.findAll(new SearchClienteSpecification(request), PageRequest.of(page, 50));

    List<ClienteDto> clientes = pl.getContent()
        .stream()
        .map(clienteMapper::toDto)
        .collect(Collectors.toList());

    return clientes;
  }

  public ClienteResponse findById(Long clienteId){
    ClienteResponse response = new ClienteResponse();
    ClienteDto clienteDto = clienteMapper.toDto(clienteRepository.findById(clienteId).orElse(null));

    if (nonNull(clienteDto)){
      response.setCliente(clienteDto);
    }

    return response;
  }

  public void deleteById(Long clienteId){
    clienteRepository.deleteById(clienteId);
  }

  public ClienteDto findDtoById(Long clienteId){
    return clienteMapper.toDto(clienteRepository.findById(clienteId).orElse(null));
  }

  public String formatClienteEndereco(ClienteDto dto){
    return dto.getEndereco() + ", " + dto.getBairro() + " - " +dto.getCidade() + "/" + dto.getEstado();
  }

}
