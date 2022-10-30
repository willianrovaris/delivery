package com.fiserv.delivery.specification;

import static java.util.Objects.nonNull;

import com.fiserv.delivery.domain.request.FuncionarioRequest;
import com.fiserv.delivery.entity.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class SearchFuncionarioSpecification implements Specification<Funcionario> {

  private FuncionarioRequest request;
  private static final String UNIQUE_ID = "uniqueID";
  private static final String MATRICULA = "matricula";
  private static final String NOME = "nome";
  private static final String ADMISSAO_DT = "admissaoDt";
  private static final String PERIODO_TRABALHO = "periodoTrabalho";

  public SearchFuncionarioSpecification(FuncionarioRequest request){
    this.request = request;
  }

  @Override
  public Predicate toPredicate(Root<Funcionario> root, CriteriaQuery<?> query,
      CriteriaBuilder criteriaBuilder) {

    List<Predicate> predicates = new ArrayList<>();

    if (nonNull(request.getUniqueId())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(UNIQUE_ID),
          request.getUniqueId()
      )));
    }

    if (nonNull(request.getMatricula())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(MATRICULA),
          request.getMatricula()
      )));
    }

    if (nonNull(request.getNome())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(NOME),
          request.getNome()
      )));
    }

    if (nonNull(request.getDataAdmissaoDe())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(
          root.get(ADMISSAO_DT),
          request.getDataAdmissaoDe()
      )));
    }

    if (nonNull(request.getDataAdmissaoAte())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(
          root.get(ADMISSAO_DT),
          request.getDataAdmissaoAte()
      )));
    }

    if (nonNull(request.getPeriodoTrabalho())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(PERIODO_TRABALHO),
          request.getPeriodoTrabalho()
      )));
    }

    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }

  @Override
  public Specification<Funcionario> and(Specification<Funcionario> other) {
    return Specification.super.and(other);
  }

  @Override
  public Specification<Funcionario> or(Specification<Funcionario> other) {
    return Specification.super.or(other);
  }
}
