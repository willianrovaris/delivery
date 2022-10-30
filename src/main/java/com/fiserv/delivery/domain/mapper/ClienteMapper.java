package com.fiserv.delivery.domain.mapper;

import com.fiserv.delivery.domain.dto.ClienteDto;
import com.fiserv.delivery.entity.Cliente;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

  List<ClienteDto> toDto(List<Cliente> models);
  ClienteDto toDto(Cliente model);
  @InheritInverseConfiguration
  List<Cliente> fromDto(List<ClienteDto> model);
  @InheritInverseConfiguration
  Cliente fromDto(ClienteDto model);

}
