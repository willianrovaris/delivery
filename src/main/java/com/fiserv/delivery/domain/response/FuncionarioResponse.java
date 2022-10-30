package com.fiserv.delivery.domain.response;

import com.fiserv.delivery.domain.dto.FuncionarioDto;
import java.util.List;

public class FuncionarioResponse {

  private List<FuncionarioDto> funcionarios;

  private FuncionarioDto funcionario;

  public List<FuncionarioDto> getFuncionarios() {
    return funcionarios;
  }

  public void setFuncionarios(List<FuncionarioDto> funcionarios) {
    this.funcionarios = funcionarios;
  }

  public FuncionarioDto getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(FuncionarioDto funcionario) {
    this.funcionario = funcionario;
  }
}
