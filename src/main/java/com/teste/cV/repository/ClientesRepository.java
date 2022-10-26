package com.teste.cV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.cV.model.Clientes;


@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
