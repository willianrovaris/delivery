package com.fiserv.delivery.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;

public class AgendamentoEntregaRequest implements Serializable {

  private Long uniqueId;
  private Long entregaUniqueId;
  private Long funcionarioUniqueId;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate entrega;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate entregaDe;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate entregaAte;

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

  public LocalDate getEntrega() {
    return entrega;
  }

  public void setEntrega(LocalDate entrega) {
    this.entrega = entrega;
  }

  public LocalDate getEntregaDe() {
    return entregaDe;
  }

  public void setEntregaDe(LocalDate entregaDe) {
    this.entregaDe = entregaDe;
  }

  public LocalDate getEntregaAte() {
    return entregaAte;
  }

  public void setEntregaAte(LocalDate entregaAte) {
    this.entregaAte = entregaAte;
  }
}
