package com.fiserv.delivery.domain.request;

import java.io.Serializable;

public class EntregaRequest implements Serializable {

  private Long uniqueId;
  private Long clienteUniqueId;
  private Long numeroPedido;

  public Long getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(Long uniqueId) {
    this.uniqueId = uniqueId;
  }

  public Long getClienteUniqueId() {
    return clienteUniqueId;
  }

  public void setClienteUniqueId(Long clienteUniqueId) {
    this.clienteUniqueId = clienteUniqueId;
  }

  public Long getNumeroPedido() {
    return numeroPedido;
  }

  public void setNumeroPedido(Long numeroPedido) {
    this.numeroPedido = numeroPedido;
  }
}
