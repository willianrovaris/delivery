package com.fiserv.delivery.specification;

import static java.util.Objects.nonNull;

import com.fiserv.delivery.domain.request.ClienteRequest;
import com.fiserv.delivery.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class SearchClienteSpecification implements Specification<Cliente> {

  private ClienteRequest request;
  private static final String UNIQUE_ID = "uniqueID";
  private static final String NOME = "nome";
  private static final String CIDADE = "cidade";
  private static final String ESTADO = "estado";
  private static final String PAIS = "pais";

  public SearchClienteSpecification(ClienteRequest request){
    this.request = request;
  }

  @Override
  public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query,
      CriteriaBuilder criteriaBuilder) {

    List<Predicate> predicates = new ArrayList<>();

    if (nonNull(request.getUniqueId())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(UNIQUE_ID),
          request.getUniqueId()
      )));
    }

    if (nonNull(request.getNome())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(NOME),
          request.getNome()
      )));
    }

    if (nonNull(request.getCidade())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(CIDADE),
          request.getCidade()
      )));
    }

    if (nonNull(request.getEstado())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(ESTADO),
          request.getEstado()
      )));
    }

    if (nonNull(request.getPais())){
      predicates.add(criteriaBuilder.and(criteriaBuilder.equal(
          root.get(PAIS),
          request.getPais()
      )));
    }

    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }

  @Override
  public Specification<Cliente> and(Specification<Cliente> other) {
    return Specification.super.and(other);
  }

  @Override
  public Specification<Cliente> or(Specification<Cliente> other) {
    return Specification.super.or(other);
  }
}
