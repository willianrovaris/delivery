package com.fiserv.delivery.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class AgendamentoEntregaDto implements Serializable {

  private Long uniqueId;
  private EntregaDto entrega;
  private FuncionarioDto funcionario;
  private LocalDate dataEntrega;
  private LocalDate dtCriacao;
  private String usuarioCriacao;

  public AgendamentoEntregaDto(){
  }

  public AgendamentoEntregaDto(EntregaDto entrega, FuncionarioDto funcionario, LocalDate dataEntrega){
    this.entrega = entrega;
    this.funcionario = funcionario;
    this.dataEntrega = dataEntrega;
  }

  public Long getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(Long uniqueId) {
    this.uniqueId = uniqueId;
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

  public LocalDate getDtCriacao() {
    return dtCriacao;
  }

  public void setDtCriacao(LocalDate dtCriacao) {
    this.dtCriacao = dtCriacao;
  }

  public String getUsuarioCriacao() {
    return usuarioCriacao;
  }

  public void setUsuarioCriacao(String usuarioCriacao) {
    this.usuarioCriacao = usuarioCriacao;
  }
}
