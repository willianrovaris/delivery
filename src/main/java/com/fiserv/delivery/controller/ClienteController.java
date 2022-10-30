package com.fiserv.delivery.controller;

import com.fiserv.delivery.domain.request.ClienteRequest;
import com.fiserv.delivery.domain.response.ClienteResponse;
import com.fiserv.delivery.service.ClienteService;
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
@Api(value = "Cliente endpoints", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Validated
@CrossOrigin
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  private static final String PATH = "/v1/clientes";

  @ApiOperation(value = "Get All Clientes", nickname = "getAllClientes")
  @RequestMapping(path = PATH + "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ClienteResponse getAllClientes(
      @RequestBody ClienteRequest request,
      @RequestParam(name = "page", defaultValue = "0") Integer page){
    ClienteResponse response = new ClienteResponse();
    response.setClientes(clienteService.findAll(request, page));
    return response;
  }

  @ApiOperation(value = "Find Cliente By Id", nickname = "findById")
  @RequestMapping(path = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ClienteResponse findById(
      @PathVariable(value = "id") Long clienteId){
    return clienteService.findById(clienteId);
  }

  @ApiOperation(value = "Create Cliente", nickname = "create")
  @RequestMapping(path = PATH + "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ClienteResponse create(
      @RequestBody ClienteRequest request){
    ClienteResponse response = new ClienteResponse();
    response.setCliente(clienteService.save(request));
    return response;
  }

  @ApiOperation(value = "Delete Cliente By Id", nickname = "deleteById")
  @RequestMapping(path = PATH + "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteById(
      @PathVariable(value = "id") Long clienteId){
    clienteService.deleteById(clienteId);
  }

  @ApiOperation(value = "Modify Cliente", nickname = "modify")
  @RequestMapping(path = PATH + "/modify/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ClienteResponse modify(
      @RequestBody ClienteRequest request,
      @PathVariable(value = "id") Long clienteId){
    ClienteResponse response = new ClienteResponse();
    response.setCliente(clienteService.modify(clienteId, request));
    return response;
  }

}
