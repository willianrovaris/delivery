package com.fiserv.delivery.service;

import static java.util.Objects.nonNull;

import com.fiserv.delivery.domain.dto.AgendamentoEntregaDto;
import com.fiserv.delivery.domain.dto.EntregaDto;
import com.fiserv.delivery.domain.dto.FuncionarioDto;
import com.fiserv.delivery.domain.mapper.AgendamentoEntregaMapper;
import com.fiserv.delivery.domain.request.AgendamentoEntregaRequest;
import com.fiserv.delivery.domain.response.AgendamentoEntregaResponse;
import com.fiserv.delivery.entity.AgendamentoEntrega;
import com.fiserv.delivery.entity.Entrega;
import com.fiserv.delivery.entity.Funcionario;
import com.fiserv.delivery.repository.AgendamentoEntregaRepository;
import com.fiserv.delivery.specification.SearchAgendamentoEntregaSpecification;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "transactionManager")
public class AgendamentoEntregaService {

  @Autowired
  private AgendamentoEntregaRepository agendamentoEntregaRepository;

  @Autowired
  private AgendamentoEntregaMapper agendamentoEntregaMapper;

  @Autowired
  private FuncionarioService funcionarioService;

  @Autowired
  private EntregaService entregaService;

  public AgendamentoEntregaDto save(AgendamentoEntregaRequest request){

    AgendamentoEntrega agendamentoEntrega = agendamentoEntregaRepository.findByEntregaUniqueId(request.getEntregaUniqueId());

    agendamentoEntregaValidations(agendamentoEntrega);

    FuncionarioDto funcionarioDto = funcionarioService.findDtoById(request.getFuncionarioUniqueId());
    EntregaDto entregaDto = entregaService.findDtoById(request.getEntregaUniqueId());

    AgendamentoEntregaDto agendamentoEntregaDto = new AgendamentoEntregaDto(entregaDto, funcionarioDto,
        request.getDataEntrega());

    return agendamentoEntregaMapper.toDto(agendamentoEntregaRepository.save(agendamentoEntregaMapper.fromDto(agendamentoEntregaDto)));
  }

  public AgendamentoEntregaDto modify(Long agendamentoEntregaId, AgendamentoEntregaRequest request){
    AgendamentoEntrega agendamentoEntrega = agendamentoEntregaRepository.findByEntregaUniqueId(request.getEntregaUniqueId());

    agendamentoEntregaValidations(agendamentoEntrega);

    AgendamentoEntregaDto agendamentoEntregaDto = agendamentoEntregaMapper.toDto(agendamentoEntregaRepository.findById(agendamentoEntregaId).orElseThrow(() -> new RuntimeException("Entrega nao existe!")));
    FuncionarioDto funcionarioDto = funcionarioService.findDtoById(request.getFuncionarioUniqueId());
    EntregaDto entregaDto = entregaService.findDtoById(request.getEntregaUniqueId());

    agendamentoEntregaDto.setEntrega(entregaDto);
    agendamentoEntregaDto.setFuncionario(funcionarioDto);
    agendamentoEntregaDto.setDataEntrega(request.getDataEntrega());

    return agendamentoEntregaMapper.toDto(agendamentoEntregaRepository.save(agendamentoEntregaMapper.fromDto(agendamentoEntregaDto)));
  }

  public List<AgendamentoEntregaDto> findAll(AgendamentoEntregaRequest request, Integer page){
    Page<AgendamentoEntrega> pl = agendamentoEntregaRepository.findAll(new SearchAgendamentoEntregaSpecification(request), PageRequest.of(page, 50));

    List<AgendamentoEntregaDto> agendamentoEntregas = pl.getContent()
        .stream()
        .map(agendamentoEntregaMapper::toDto)
        .collect(Collectors.toList());

    return agendamentoEntregas;

  }

  public AgendamentoEntregaResponse findById(Long agendamentoEntregaId){
    AgendamentoEntregaResponse response = new AgendamentoEntregaResponse();

    AgendamentoEntregaDto agendamentoEntregaDto = agendamentoEntregaMapper.toDto(agendamentoEntregaRepository.findById(agendamentoEntregaId).orElse(null));

    if (Objects.nonNull(agendamentoEntregaDto)){
      response.setAgendamentoEntrega(agendamentoEntregaDto);
    }

    return response;
  }

  public void deleteById(Long agendamentoEntregaId){
    agendamentoEntregaRepository.deleteById(agendamentoEntregaId);
  }

  public void agendamentoEntregaValidations(AgendamentoEntrega entity){
    if (nonNull(entity)){
      Entrega entrega = entity.getEntrega();
      Funcionario funcionario = entity.getFuncionario();
      throw new RuntimeException("Ja foi realizado o agendamento de entrega para o pedido de numero: "
          +entrega.getNumeroPedido()+ " para o funcionario: " + funcionario.getMatricula() + " - " + funcionario.getNome());
    }
  }
}
