package com.tsti.servicios;

import java.util.List;
import java.util.Optional;

import com.tsti.entidades.Cliente;


public interface ClienteService {
	
	/**
	 * Devuelve la lista completa de Clientes
	 * @return Lista de clientes
	 */
	public List<Cliente> getAll();

	/**
	 * Obtiene un cliente a partir de su identidicador
	 * @param id
	 * @return
	 */
	public Optional<Cliente> getById(Long id);

	/**
	 * Actualiza datos de un Cliente
	 * @param c
	 */
	public void update(Cliente c);

	/**
	 * Inserta una nuevo cliente
	 * @param c
	 * @throws Exception
	 */
	public void insert(Cliente c) throws Exception;

	/**
	 * Elimina un cliente del sistema
	 * @param id dni del cliente a eliminar
	 */
	public void delete(Long id);

	public List<Cliente> filtrar(String apellido, String nombre);

}
