package com.teste.cV.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.cV.model.Vendedores;


@Repository 
public interface VendedoresRepository extends JpaRepository<Vendedores, Long>{

}
