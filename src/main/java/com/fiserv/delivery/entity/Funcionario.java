package com.fiserv.delivery.entity;

import java.time.LocalDate;
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
@Table(name = "FUNCIONARIOS")
@DynamicInsert
@DynamicUpdate
public class Funcionario extends AuditableEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FUNCIONARIOS")
  @SequenceGenerator(sequenceName = "SQ_FUNCIONARIOS", allocationSize = 1, name = "SQ_FUNCIONARIOS")
  @NotNull
  @Column(name = "FUNCIONARIO_UID")
  private Long uniqueId;

  @NotNull
  @Column(name = "MATRICULA", nullable = false, length = 10)
  private Long matricula;

  @NotNull
  @Column(name = "CPF", nullable = false, length = 11)
  private String cpf;

  @NotNull
  @Column(name = "NOME", nullable = false, length = 200)
  private String nome;

  @Column(name = "ADMISSAO_DT")
  private LocalDate admissaoDt;

  @NotNull
  @Column(name = "PERIODO_TRABALHO", nullable = false, length = 1)
  private String periodoTrabalho;

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

  public String getPeriodoTrabalho() {
    return periodoTrabalho;
  }

  public void setPeriodoTrabalho(String periodoTrabalho) {
    this.periodoTrabalho = periodoTrabalho;
  }
}
