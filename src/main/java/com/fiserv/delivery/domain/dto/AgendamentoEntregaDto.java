package com.fiserv.delivery.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class AgendamentoEntregaDto implements Serializable {

  private EntregaDto entrega;
  private FuncionarioDto funcionario;
  private LocalDate dataEntrega;

  public AgendamentoEntregaDto(){
  }

  public AgendamentoEntregaDto(EntregaDto entrega, FuncionarioDto funcionario, LocalDate dataEntrega){
    this.entrega = entrega;
    this.funcionario = funcionario;
    this.dataEntrega = dataEntrega;
  }

  public EntregaDto getEntrega() {
    return entrega;
  }

  public void setEntrega(EntregaDto entrega) {
    this.entrega = entrega;
  }

  public FuncionarioDto getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(FuncionarioDto funcionario) {
    this.funcionario = funcionario;
  }

  public LocalDate getDataEntrega() {
    return dataEntrega;
  }

  public void setDataEntrega(LocalDate dataEntrega) {
    this.dataEntrega = dataEntrega;
  }
}
