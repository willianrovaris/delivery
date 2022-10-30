package com.fiserv.delivery.controller;

import com.fiserv.delivery.domain.request.FuncionarioRequest;
import com.fiserv.delivery.domain.response.FuncionarioResponse;
import com.fiserv.delivery.service.FuncionarioService;
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
@Api(value = "Funcionario endpoints", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Validated
@CrossOrigin
public class FuncionarioController {

  @Autowired
  private FuncionarioService funcionarioService;

  private static final String PATH = "/v1/funcionarios";

  @ApiOperation(value = "Get All Funcionarios", nickname = "getAllFuncionarios")
  @RequestMapping(path = PATH + "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public FuncionarioResponse getAllFuncionarios(
      @RequestBody FuncionarioRequest request,
      @RequestParam(name = "page", defaultValue = "0") Integer page){
    FuncionarioResponse funcionarioResponse = new FuncionarioResponse();
    funcionarioResponse.setFuncionarios(funcionarioService.findAll(request, page));
    return funcionarioResponse;
  }

  @ApiOperation(value = "Find Funcionario By Id", nickname = "findById")
  @RequestMapping(path = PATH + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public FuncionarioResponse findById(
      @PathVariable(value = "id") Long funcionarioId){
    return funcionarioService.findById(funcionarioId);
  }

  @ApiOperation(value = "Create Funcionario", nickname = "create")
  @RequestMapping(path = PATH + "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public FuncionarioResponse create(
      @RequestBody FuncionarioRequest request){
    FuncionarioResponse response = new FuncionarioResponse();
    response.setFuncionario(funcionarioService.save(request));
    return response;
  }

  @ApiOperation(value = "Delete Funcionario By Id", nickname = "deleteById")
  @RequestMapping(path = PATH + "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteById(
      @PathVariable(value = "id") Long funcionarioId){
    funcionarioService.deleteById(funcionarioId);
  }

}
