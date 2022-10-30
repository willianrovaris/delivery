package com.fiserv.delivery.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class EntregaDto implements Serializable {

  private Long uniqueId;
  private ClienteDto cliente;
  private Long numeroPedido;
  private String endereco;
  private LocalDate dtCriacao;
  private String usuarioCriacao;

  public EntregaDto(){
  }

  public EntregaDto(ClienteDto cliente, Long numeroPedido, String endereco){
    this.cliente = cliente;
    this.numeroPedido = numeroPedido;
    this.endereco = endereco;
  }

  public Long getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(Long uniqueId) {
    this.uniqueId = uniqueId;
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
