package com.fiserv.delivery.domain.response;

import com.fiserv.delivery.domain.dto.ClienteDto;
import java.util.List;

public class ClienteResponse {

  private List<ClienteDto> clientes;

  private ClienteDto cliente;

  public List<ClienteDto> getClientes() {
    return clientes;
  }

  public void setClientes(List<ClienteDto> clientes) {
    this.clientes = clientes;
  }

  public ClienteDto getCliente() {
    return cliente;
  }

  public void setCliente(ClienteDto cliente) {
    this.cliente = cliente;
  }
}
