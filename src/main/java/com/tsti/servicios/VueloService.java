package com.tsti.servicios;

import java.util.List;
import java.util.Optional;

import com.tsti.entidades.Vuelo;


public interface VueloService {
	
	/**
	 * Devuelve la lista completa de Vuelos
	 * @return Lista de Vuelos
	 */
	public List<Vuelo> getAll();

	/**
	 * Obtiene un Vuelo a partir de su identidicador
	 * @param id
	 * @return
	 */
	public Optional<Vuelo> getById(Long id);

	/**
	 * Actualiza datos de un Vuelo
	 * @param c
	 */
	public void update(Vuelo v);

	/**
	 * Inserta una nuevo Vuelo
	 * @param v
	 * @throws Exception
	 */
	public void insert(Vuelo v) throws Exception;

	/**
	 * Elimina un Vuelo del sistema
	 * @param id dni del Vuelo a eliminar
	 */
	public void delete(Long id);

	public List<Vuelo> filtrar(String destino);

}
