package com.fiserv.delivery.domain.dto;

import java.io.Serializable;

public class EntregaDto implements Serializable {

  private ClienteDto cliente;
  private Long numeroPedido;
  private String endereco;

  public EntregaDto(){
  }

  public EntregaDto(ClienteDto cliente, Long numeroPedido, String endereco){
    this.cliente = cliente;
    this.numeroPedido = numeroPedido;
    this.endereco = endereco;
  }

  public ClienteDto getCliente() {
    return cliente;
  }

  public void setCliente(ClienteDto cliente) {
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
