package com.fiserv.delivery.service;

import com.fiserv.delivery.domain.dto.AgendamentoEntregaDto;
import com.fiserv.delivery.domain.mapper.AgendamentoEntregaMapper;
import com.fiserv.delivery.domain.request.AgendamentoEntregaRequest;
import com.fiserv.delivery.domain.response.AgendamentoEntregaResponse;
import com.fiserv.delivery.entity.AgendamentoEntrega;
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

  public AgendamentoEntregaDto save(AgendamentoEntregaRequest request){
    AgendamentoEntregaDto agendamentoEntregaDto = new AgendamentoEntregaDto();

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
}
