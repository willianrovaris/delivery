package com.fiserv.delivery.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;

public class AgendamentoEntregaRequest implements Serializable {

  private Long uniqueId;
  private Long entregaUniqueId;
  private Long funcionarioUniqueId;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate dataEntrega;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate dataEntregaDe;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate dataEntregaAte;

  public Long getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(Long uniqueId) {
    this.uniqueId = uniqueId;
  }

  public Long getEntregaUniqueId() {
    return entregaUniqueId;
  }

  public void setEntregaUniqueId(Long entregaUniqueId) {
    this.entregaUniqueId = entregaUniqueId;
  }

  public Long getFuncionarioUniqueId() {
    return funcionarioUniqueId;
  }

  public void setFuncionarioUniqueId(Long funcionarioUniqueId) {
    this.funcionarioUniqueId = funcionarioUniqueId;
  }

  public LocalDate getDataEntrega() {
    return dataEntrega;
  }

  public void setDataEntrega(LocalDate dataEntrega) {
    this.dataEntrega = dataEntrega;
  }

  public LocalDate getDataEntregaDe() {
    return dataEntregaDe;
  }

  public void setDataEntregaDe(LocalDate dataEntregaDe) {
    this.dataEntregaDe = dataEntregaDe;
  }

  public LocalDate getDataEntregaAte() {
    return dataEntregaAte;
  }

  public void setDataEntregaAte(LocalDate dataEntregaAte) {
    this.dataEntregaAte = dataEntregaAte;
  }
}
