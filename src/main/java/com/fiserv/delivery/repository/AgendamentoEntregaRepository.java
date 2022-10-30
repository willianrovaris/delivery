package com.fiserv.delivery.repository;

import com.fiserv.delivery.entity.AgendamentoEntrega;
import com.fiserv.delivery.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoEntregaRepository extends JpaRepository<AgendamentoEntrega, Long>,
    JpaSpecificationExecutor<AgendamentoEntrega> {

  AgendamentoEntrega findByEntregaUniqueId(@Param("entregaUniqueId") Long entregaUniqueId);

}
