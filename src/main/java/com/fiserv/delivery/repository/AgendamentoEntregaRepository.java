package com.fiserv.delivery.repository;

import com.fiserv.delivery.entity.AgendamentoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoEntregaRepository extends JpaRepository<AgendamentoEntrega, Long>,
    JpaSpecificationExecutor<AgendamentoEntrega> {

}
