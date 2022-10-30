package com.fiserv.delivery.domain.mapper;

import com.fiserv.delivery.domain.dto.FuncionarioDto;
import com.fiserv.delivery.entity.Funcionario;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FuncionarioMapper {

  List<FuncionarioDto> toDto(List<Funcionario> models);
  FuncionarioDto toDto(Funcionario model);
  @InheritInverseConfiguration
  List<Funcionario> fromDto(List<FuncionarioDto> model);
  @InheritInverseConfiguration
  Funcionario fromDto(FuncionarioDto model);

}
