package com.fiserv.delivery.entity;

import com.fiserv.delivery.util.AuditableListener;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

@EntityListeners(AuditableListener.class)
@MappedSuperclass
public class AuditableEntity implements Serializable {

  @NotNull
  @Column(name="DT_CRIACAO", nullable = false)
  @CreatedDate
  private LocalDate dtCriacao;

  @NotNull
  @Column(name="USUARIO_CRIACAO", nullable = false, length = 100)
  @CreatedDate
  private String usuarioCriacao;

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
