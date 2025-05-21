package com.projeto.crud.repository;

import com.projeto.crud.model.Empregado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

    Page<Empregado> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<Empregado> findByCargo_NomeIgnoreCase(String cargoNome, Pageable pageable);

    Page<Empregado> findByNomeContainingIgnoreCaseAndCargo_NomeIgnoreCase(String nome, String cargoNome, Pageable pageable);

    List<Empregado> findByNomeContainingIgnoreCaseAndCargo_NomeContainingIgnoreCase(String nome, String cargoNome);

    List<Empregado> findByCargo_NomeContainingIgnoreCase(String nome);

    List<Empregado> findByNomeContainingIgnoreCase(String nome);
}
