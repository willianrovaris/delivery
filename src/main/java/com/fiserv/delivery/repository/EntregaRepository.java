package com.fiserv.delivery.repository;

import com.fiserv.delivery.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>,
    JpaSpecificationExecutor<Entrega> {

}
