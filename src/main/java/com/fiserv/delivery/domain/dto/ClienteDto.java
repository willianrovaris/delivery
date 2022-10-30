package com.fiserv.delivery.domain.dto;

import java.io.Serializable;

public class ClienteDto implements Serializable {

  private Long uniqueId;
  private String cpf;
  private String nome;
  private String endereco;
  private String bairro;
  private String cidade;
  private String estado;
  private String pais;

  public ClienteDto(){
  }

  public ClienteDto(String cpf, String nome, String endereco, String bairro, String cidade, String estado,
      String pais){
    this.cpf = cpf;
    this.nome = nome;
    this.endereco = endereco;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.pais = pais;
  }



  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }
}
