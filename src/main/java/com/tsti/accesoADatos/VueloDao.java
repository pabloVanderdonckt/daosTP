package com.tsti.accesoADatos;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tsti.entidades.Vuelo;

public interface VueloDao extends JpaRepository<Vuelo, Long>{
	
	@Query("SELECT v FROM Vuelo v WHERE v.destino like '%?1%'")
	Collection<Vuelo> findPersonasLike(String parte);
	
	public List<Vuelo> findByDestino(String destino);
}
