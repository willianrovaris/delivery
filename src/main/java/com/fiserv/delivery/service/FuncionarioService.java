package com.fiserv.delivery.service;

import static java.util.Objects.nonNull;

import com.fiserv.delivery.domain.dto.FuncionarioDto;
import com.fiserv.delivery.domain.mapper.FuncionarioMapper;
import com.fiserv.delivery.domain.request.FuncionarioRequest;
import com.fiserv.delivery.domain.response.FuncionarioResponse;
import com.fiserv.delivery.entity.Funcionario;
import com.fiserv.delivery.repository.FuncionarioRepository;
import com.fiserv.delivery.specification.SearchFuncionarioSpecification;
import com.fiserv.delivery.util.ValidacaoCPF;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "transactionManager")
public class FuncionarioService {

  @Autowired
  private FuncionarioRepository funcionarioRepository;

  @Autowired
  private FuncionarioMapper funcionarioMapper;

  public FuncionarioDto save(FuncionarioRequest request){
    if (nonNull(funcionarioRepository.findByMatricula(request.getMatricula()))){
      throw new RuntimeException("A Matricula "+request.getMatricula()+ " ja existe no sistema!");
    }

    if ((!ValidacaoCPF.isCPF(request.getCpf())) || (nonNull(funcionarioRepository.findByCpf(request.getCpf()))) ){
      throw new RuntimeException("CPF Invalido ou ja cadastrado no sistema!");
    }

    FuncionarioDto funcionarioDto = new FuncionarioDto(request.getCpf(), request.getNome(),
        request.getMatricula(), request.getDataAdmissao(), request.getPeriodoTrabalho());

    return funcionarioMapper.toDto(funcionarioRepository.save(funcionarioMapper.fromDto(funcionarioDto)));
  }

  public List<FuncionarioDto> findAll(FuncionarioRequest request, Integer page){
    Page<Funcionario> pl = funcionarioRepository.findAll(new SearchFuncionarioSpecification(request), PageRequest.of(page, 50));

    List<FuncionarioDto> funcionarios = pl.getContent()
        .stream()
        .map(funcionarioMapper::toDto)
        .collect(Collectors.toList());

    return funcionarios;
  }

  public FuncionarioResponse findById(Long funcionarioId){
    FuncionarioResponse response = new FuncionarioResponse();

    FuncionarioDto funcionarioDto = funcionarioMapper.toDto(funcionarioRepository.findById(funcionarioId).orElse(null));

    if (nonNull(funcionarioDto)){
      response.setFuncionario(funcionarioDto);
    }

    return response;
  }

  public void deleteById(Long funcionarioId){
    funcionarioRepository.deleteById(funcionarioId);
  }

  public FuncionarioDto findDtoById(Long funcionarioId){
    return funcionarioMapper.toDto(funcionarioRepository.findById(funcionarioId).orElse(null));
  }

}
