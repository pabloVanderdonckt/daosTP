package com.tsti.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.accesoADatos.EstadoDAO;
import com.tsti.entidades.Estado;
@Service
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	private EstadoDAO dao;
	
	@Override
	public java.util.List<Estado> findAll()
	{
		return dao.findAll();
	}

	@Override
	public Optional<Estado> getById(Long id) {
		return  dao.findById(id);
		
	}
}
