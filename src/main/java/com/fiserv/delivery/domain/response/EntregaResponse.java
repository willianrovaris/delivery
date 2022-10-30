package com.fiserv.delivery.domain.response;

import com.fiserv.delivery.domain.dto.EntregaDto;
import java.util.List;

public class EntregaResponse {

  private List<EntregaDto> entregas;

  private EntregaDto entrega;

  public List<EntregaDto> getEntregas() {
    return entregas;
  }

  public void setEntregas(List<EntregaDto> entregas) {
    this.entregas = entregas;
  }

  public EntregaDto getEntrega() {
    return entrega;
  }

  public void setEntrega(EntregaDto entrega) {
    this.entrega = entrega;
  }
}
