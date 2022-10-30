package com.fiserv.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "CLIENTES")
@DynamicInsert
@DynamicUpdate
public class Cliente extends AuditableEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLIENTES")
  @SequenceGenerator(sequenceName = "SQ_CLIENTES", allocationSize = 1, name = "SQ_CLIENTES")
  @NotNull
  @Column(name = "CLIENTE_UID")
  private Long uniqueId;

  @NotNull
  @Column(name = "CPF", nullable = false, length = 11)
  private String cpf;

  @NotNull
  @Column(name = "NOME", nullable = false, length = 200)
  private String nome;

  @NotNull
  @Column(name = "ENDERECO", nullable = false, length = 1000)
  private String endereco;

  @NotNull
  @Column(name = "BAIRRO", nullable = false, length = 100)
  private String bairro;

  @NotNull
  @Column(name = "CIDADE", nullable = false, length = 100)
  private String cidade;

  @NotNull
  @Column(name = "ESTADO", nullable = false, length = 2)
  private String estado;

  @NotNull
  @Column(name = "PAIS", nullable = false, length = 100)
  private String pais;

  public Long getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(Long uniqueId) {
    this.uniqueId = uniqueId;
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
