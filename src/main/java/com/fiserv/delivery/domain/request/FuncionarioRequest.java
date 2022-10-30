package com.fiserv.delivery.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;

public class FuncionarioRequest implements Serializable {

  private Long uniqueId;
  private String cpf;
  private Long matricula;
  private String nome;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate dataAdmissao;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate dataAdmissaoDe;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate dataAdmissaoAte;
  private char periodoTrabalho;

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

  public Long getMatricula() {
    return matricula;
  }

  public void setMatricula(Long matricula) {
    this.matricula = matricula;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataAdmissao() {
    return dataAdmissao;
  }

  public void setDataAdmissao(LocalDate dataAdmissao) {
    this.dataAdmissao = dataAdmissao;
  }

  public LocalDate getDataAdmissaoDe() {
    return dataAdmissaoDe;
  }

  public void setDataAdmissaoDe(LocalDate dataAdmissaoDe) {
    this.dataAdmissaoDe = dataAdmissaoDe;
  }

  public LocalDate getDataAdmissaoAte() {
    return dataAdmissaoAte;
  }

  public void setDataAdmissaoAte(LocalDate dataAdmissaoAte) {
    this.dataAdmissaoAte = dataAdmissaoAte;
  }

  public char getPeriodoTrabalho() {
    return periodoTrabalho;
  }

  public void setPeriodoTrabalho(char periodoTrabalho) {
    this.periodoTrabalho = periodoTrabalho;
  }


}
