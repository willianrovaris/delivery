package com.fiserv.delivery.controller;

import com.fiserv.delivery.domain.request.AgendamentoEntregaRequest;
import com.fiserv.delivery.domain.response.AgendamentoEntregaResponse;
import com.fiserv.delivery.service.AgendamentoEntregaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Agendamento Entrega Endpoints", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Validated
@CrossOrigin
public class AgendamentoEntregaController {

  @Autowired
  private AgendamentoEntregaService agendamentoEntregaService;

  private static final String PATH = "/v1/agendamento-entregas";

  @ApiOperation(value = "Get All Agendamentos", nickname = "getAllAgendamentos")
  @RequestMapping(path = PATH + "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public AgendamentoEntregaResponse getAllAgendamentos(
      @RequestBody AgendamentoEntregaRequest request,
      @RequestParam(name = "page", defaultValue = "0") Integer page){
    AgendamentoEntregaResponse response = new AgendamentoEntregaResponse();
    response.setAgendamentoEntregas(agendamentoEntregaService.findAll(request, page));
    return response;
  }

  @ApiOperation(value = "Find Agendamento By Id", nickname = "findById")
  @RequestMapping(path = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public AgendamentoEntregaResponse findById(
      @PathVariable(value = "id") Long agendamentoEntregaId){
    return agendamentoEntregaService.findById(agendamentoEntregaId);
  }

  @ApiOperation(value = "Create AgendamentoEntrega", nickname = "create")
  @RequestMapping(path = PATH + "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public AgendamentoEntregaResponse create(
      @RequestBody AgendamentoEntregaRequest request){
    AgendamentoEntregaResponse response = new AgendamentoEntregaResponse();
    response.setAgendamentoEntrega(agendamentoEntregaService.save(request));
    return response;
  }

  @ApiOperation(value = "Delete Agendamento By Id", nickname = "deleteById")
  @RequestMapping(path = PATH + "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteById(
      @PathVariable(value = "id") Long agendamentoEntregaId){
    agendamentoEntregaService.deleteById(agendamentoEntregaId);
  }

}
