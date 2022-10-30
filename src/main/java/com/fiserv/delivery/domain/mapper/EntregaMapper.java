package com.fiserv.delivery.domain.mapper;

import com.fiserv.delivery.domain.dto.EntregaDto;
import com.fiserv.delivery.entity.Entrega;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntregaMapper {

  List<EntregaDto> toDto(List<Entrega> models);
  EntregaDto toDto(Entrega model);
  @InheritInverseConfiguration
  List<Entrega> fromDto(List<EntregaDto> model);
  @InheritInverseConfiguration
  Entrega fromDto(EntregaDto model);

}
