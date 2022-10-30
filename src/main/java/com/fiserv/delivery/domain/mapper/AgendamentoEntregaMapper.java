package com.fiserv.delivery.domain.mapper;

import com.fiserv.delivery.domain.dto.AgendamentoEntregaDto;
import com.fiserv.delivery.entity.AgendamentoEntrega;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AgendamentoEntregaMapper {

  List<AgendamentoEntregaDto> toDto(List<AgendamentoEntrega> models);
  AgendamentoEntregaDto toDto(AgendamentoEntrega model);
  @InheritInverseConfiguration
  List<AgendamentoEntrega> fromDto(List<AgendamentoEntregaDto> model);
  @InheritInverseConfiguration
  AgendamentoEntrega fromDto(AgendamentoEntregaDto model);

}
