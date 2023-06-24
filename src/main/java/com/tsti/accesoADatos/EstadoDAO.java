package com.tsti.accesoADatos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsti.entidades.Estado;

public interface EstadoDAO extends JpaRepository<Estado, Long>{

}
