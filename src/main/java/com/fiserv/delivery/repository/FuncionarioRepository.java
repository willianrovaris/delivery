package com.fiserv.delivery.repository;

import com.fiserv.delivery.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>,
    JpaSpecificationExecutor<Funcionario> {

  Funcionario findByMatricula(@Param("matricula") Long matricula);

  Funcionario findByCpf(@Param("cpf") String cpf);

}
