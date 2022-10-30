package com.fiserv.delivery.specification;

import static java.util.Objects.nonNull;

import com.fiserv.delivery.domain.request.EntregaRequest;
import com.fiserv.delivery.entity.Entrega;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class SearchEntregaSpecification implements Specification<Entrega> {

  private EntregaRequest request;
  private static final String UNIQUE_ID = "uniqueID";
  private static final String CLIENTE = "cliente";
  private static final String NUMERO_PEDIDO = "numeroPedido";

  public SearchEntregaSpecification(EntregaRequest request){
    this.request = request;
  }

  @Override
  public Predicate toPredicate(Root<Entrega> root, CriteriaQuery<?> query,
      CriteriaBuilder criteriaBuilder) {

    List<Predicate> predicates = new ArrayList<>();

    if (nonNull(request.getUniqueId())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(UNIQUE_ID),
          request.getUniqueId()
      )));
    }

    if (nonNull(request.getClienteUniqueId())) {
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.join(CLIENTE)
              .get(UNIQUE_ID),
          request.getClienteUniqueId())));
    }

    if (nonNull(request.getNumeroPedido())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(NUMERO_PEDIDO),
          request.getNumeroPedido()
      )));
    }

    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }

  @Override
  public Specification<Entrega> and(Specification<Entrega> other) {
    return Specification.super.and(other);
  }

  @Override
  public Specification<Entrega> or(Specification<Entrega> other) {
    return Specification.super.or(other);
  }
}
