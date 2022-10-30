package com.fiserv.delivery.controller;

import com.fiserv.delivery.domain.request.EntregaRequest;
import com.fiserv.delivery.domain.response.EntregaResponse;
import com.fiserv.delivery.service.EntregaService;
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
@Api(value = "Entrega endpoints", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Validated
@CrossOrigin
public class EntregaController {

  @Autowired
  private EntregaService entregaService;

  private static final String PATH = "/v1/entregas";

  @ApiOperation(value = "Get All Entregas", nickname = "getAllEntregas")
  @RequestMapping(path = PATH + "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public EntregaResponse getAllEntregas(
      @RequestBody EntregaRequest request,
      @RequestParam(name = "page", defaultValue = "0") Integer page){
    EntregaResponse response = new EntregaResponse();
    response.setEntregas(entregaService.findAll(request, page));
    return response;
  }

  @ApiOperation(value = "Find Entrega By Id", nickname = "findById")
  @RequestMapping(path = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public EntregaResponse findById(
      @PathVariable(value = "id") Long entregaId){
    return entregaService.findById(entregaId);
  }

  @ApiOperation(value = "Create Entrega", nickname = "create")
  @RequestMapping(path = PATH + "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public EntregaResponse create(
      @RequestBody EntregaRequest request){
    EntregaResponse response = new EntregaResponse();
    response.setEntrega(entregaService.save(request));
    return response;
  }

  @ApiOperation(value = "Delete Entrega By Id", nickname = "deleteById")
  @RequestMapping(path = PATH + "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteById(
      @PathVariable(value = "id") Long entregaId){
    entregaService.deleteById(entregaId);
  }

  @ApiOperation(value = "Modify Entrega", nickname = "modify")
  @RequestMapping(path = PATH + "/modify/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public EntregaResponse modify(
      @RequestBody EntregaRequest request,
      @PathVariable(value = "id") Long entregaId){
    EntregaResponse response = new EntregaResponse();
    response.setEntrega(entregaService.modify(entregaId, request));
    return response;
  }

}
