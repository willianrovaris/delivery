package com.fiserv.delivery.entity;

import com.fiserv.delivery.util.AuditableListener;
import java.io.Serializable;
import java.time.LocalDateTime;
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
  private LocalDateTime dtCriacao;

  @NotNull
  @Column(name="USUARIO_CRIACAO", nullable = false, length = 100)
  @CreatedDate
  private String usuarioCriacao;

  public LocalDateTime getDtCriacao() {
    return dtCriacao;
  }

  public void setDtCriacao(LocalDateTime dtCriacao) {
    this.dtCriacao = dtCriacao;
  }

  public String getUsuarioCriacao() {
    return usuarioCriacao;
  }

  public void setUsuarioCriacao(String usuarioCriacao) {
    this.usuarioCriacao = usuarioCriacao;
  }
}
