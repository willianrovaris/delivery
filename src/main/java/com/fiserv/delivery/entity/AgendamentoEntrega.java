package com.fiserv.delivery.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "AGENDAMENTO_ENTREGAS")
@DynamicInsert
@DynamicUpdate
public class AgendamentoEntrega extends AuditableEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AGENDAMENTO_ENTREGAS")
  @SequenceGenerator(sequenceName = "SQ_AGENDAMENTO_ENTREGAS", allocationSize = 1, name = "SQ_AGENDAMENTO_ENTREGAS")
  @NotNull
  @Column(name = "AGENDAMENTO_ENTREGA_UID")
  private Long uniqueId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ENTREGA_UID", updatable = false)
  private Entrega entrega;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FUNCIONARIO_UID", updatable = false)
  private Funcionario funcionario;

  @NotNull
  @Column(name = "DATA_ENTREGA")
  private LocalDate dataEntrega;

  public Long getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(Long uniqueId) {
    this.uniqueId = uniqueId;
  }

  public Entrega getEntrega() {
    return entrega;
  }

  public void setEntrega(Entrega entrega) {
    this.entrega = entrega;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  public LocalDate getDataEntrega() {
    return dataEntrega;
  }

  public void setDataEntrega(LocalDate dataEntrega) {
    this.dataEntrega = dataEntrega;
  }
}
