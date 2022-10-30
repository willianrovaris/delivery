package com.fiserv.delivery.domain.response;

import com.fiserv.delivery.domain.dto.AgendamentoEntregaDto;
import java.util.List;

public class AgendamentoEntregaResponse {

  private List<AgendamentoEntregaDto> agendamentoEntregas;

  private AgendamentoEntregaDto agendamentoEntrega;

  public List<AgendamentoEntregaDto> getAgendamentoEntregas() {
    return agendamentoEntregas;
  }

  public void setAgendamentoEntregas(
      List<AgendamentoEntregaDto> agendamentoEntregas) {
    this.agendamentoEntregas = agendamentoEntregas;
  }

  public AgendamentoEntregaDto getAgendamentoEntrega() {
    return agendamentoEntrega;
  }

  public void setAgendamentoEntrega(
      AgendamentoEntregaDto agendamentoEntrega) {
    this.agendamentoEntrega = agendamentoEntrega;
  }
}
