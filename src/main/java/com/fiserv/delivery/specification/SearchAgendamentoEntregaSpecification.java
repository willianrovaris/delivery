package com.fiserv.delivery.specification;

import static java.util.Objects.nonNull;

import com.fiserv.delivery.domain.request.AgendamentoEntregaRequest;
import com.fiserv.delivery.entity.AgendamentoEntrega;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class SearchAgendamentoEntregaSpecification implements Specification<AgendamentoEntrega> {

  private AgendamentoEntregaRequest request;
  private static final String UNIQUE_ID = "uniqueID";
  private static final String FUNCIONARIO = "funcionario";
  private static final String ENTREGA = "dataEntrega";
  private static final String DATA_ENTREGA = "dataEntrega";

  public SearchAgendamentoEntregaSpecification(AgendamentoEntregaRequest request){
    this.request = request;
  }

  @Override
  public Predicate toPredicate(Root<AgendamentoEntrega> root, CriteriaQuery<?> query,
      CriteriaBuilder criteriaBuilder) {

    List<Predicate> predicates = new ArrayList<>();

    if (nonNull(request.getUniqueId())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(UNIQUE_ID),
          request.getUniqueId()
      )));
    }

    if (nonNull(request.getFuncionarioUniqueId())) {
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.join(FUNCIONARIO)
              .get(UNIQUE_ID),
          request.getFuncionarioUniqueId())));
    }

    if (nonNull(request.getEntregaUniqueId())) {
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.join(ENTREGA)
              .get(UNIQUE_ID),
          request.getEntregaUniqueId())));
    }

    if (nonNull(request.getDataEntregaDe())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(
          root.get(DATA_ENTREGA),
          request.getDataEntregaDe()
      )));
    }

    if (nonNull(request.getDataEntregaAte())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(
          root.get(DATA_ENTREGA),
          request.getDataEntregaAte()
      )));
    }

    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }

  @Override
  public Specification<AgendamentoEntrega> and(Specification<AgendamentoEntrega> other) {
    return Specification.super.and(other);
  }

  @Override
  public Specification<AgendamentoEntrega> or(Specification<AgendamentoEntrega> other) {
    return Specification.super.or(other);
  }
}
