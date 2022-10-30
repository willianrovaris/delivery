package com.fiserv.delivery.repository;

import com.fiserv.delivery.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>,
    JpaSpecificationExecutor<Cliente> {

  Cliente findByCpf(@Param("cpf") String cpf);

}
