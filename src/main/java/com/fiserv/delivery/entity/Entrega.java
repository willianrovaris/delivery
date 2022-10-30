package com.fiserv.delivery.entity;

import javax.persistence.CascadeType;
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
@Table(name = "ENTREGAS")
@DynamicInsert
@DynamicUpdate
public class Entrega extends AuditableEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENTREGAS")
  @SequenceGenerator(sequenceName = "SQ_ENTREGAS", allocationSize = 1, name = "SQ_ENTREGAS")
  @NotNull
  @Column(name = "ENTREGA_UID")
  private Long uniqueId;

  @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
  @JoinColumn(name = "CLIENTE_UID", updatable = false)
  private Cliente cliente;

  @NotNull
  @Column(name = "NUM_PEDIDO", nullable = false, length = 10)
  private Long numeroPedido;

  @NotNull
  @Column(name = "ENDERECO", nullable = false, length = 2000)
  private String endereco;

  public Long getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(Long uniqueId) {
    this.uniqueId = uniqueId;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Long getNumeroPedido() {
    return numeroPedido;
  }

  public void setNumeroPedido(Long numeroPedido) {
    this.numeroPedido = numeroPedido;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
}
