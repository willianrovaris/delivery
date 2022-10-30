package com.fiserv.delivery.util;

import com.fiserv.delivery.entity.AuditableEntity;
import java.security.Principal;
import java.time.LocalDateTime;
import javax.persistence.PrePersist;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuditableListener implements ApplicationContextAware {

  private static ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    context = applicationContext;
  }

  @PrePersist
  public void setCriacao(AuditableEntity auditable) {
    auditable.setDtCriacao(LocalDateTime.now());
    auditable.setUsuarioCriacao(getUsuarioCriacao(auditable));
  }

  private String getUsuarioCriacao(AuditableEntity auditable) {
    KeycloakAuthenticationToken authentication =
        (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

    Principal principal = (Principal) authentication.getPrincipal();

    String userIdByToken = "";

    if (principal instanceof KeycloakPrincipal) {
      KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
      userIdByToken = kPrincipal.getKeycloakSecurityContext().getToken().getPreferredUsername();
    }

    return userIdByToken;
  }
}
