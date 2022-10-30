package com.fiserv.delivery.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class FuncionarioDto implements Serializable {

  private Long uniqueId;
  private String cpf;
  private String nome;
  private Long matricula;
  private LocalDate admissaoDt;
  private char periodoTrabalho;

  public FuncionarioDto(){
  }

  public FuncionarioDto(String cpf, String nome, Long matricula,  LocalDate admissaoDt,
      char periodoTrabalho){
    this.cpf = cpf;
    this.nome = nome;
    this.matricula = matricula;
    this.admissaoDt = admissaoDt;
    this.periodoTrabalho = periodoTrabalho;
  }

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

  public Long getMatricula() {
    return matricula;
  }

  public void setMatricula(Long matricula) {
    this.matricula = matricula;
  }

  public LocalDate getAdmissaoDt() {
    return admissaoDt;
  }

  public void setAdmissaoDt(LocalDate admissaoDt) {
    this.admissaoDt = admissaoDt;
  }

  public char getPeriodoTrabalho() {
    return periodoTrabalho;
  }

  public void setPeriodoTrabalho(char periodoTrabalho) {
    this.periodoTrabalho = periodoTrabalho;
  }
}
