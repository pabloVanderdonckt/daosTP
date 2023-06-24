package com.tsti.servicios;

import java.util.Optional;

import com.tsti.entidades.Estado;

public interface EstadoService {
	
	
	/**
	 * Obtiene la lista completa de estados
	 * @return
	 */
	public java.util.List<Estado> findAll();

	/**
	 * Obtiene una ciudad
	 * @param id identificador de la estado requerida
	 * @return 
	 */
	public Optional<Estado> getById(Long id);
	
}
