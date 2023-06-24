package com.tsti.presentacion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsti.entidades.Estado;
import com.tsti.servicios.EstadoService;




@RestController
@RequestMapping("/estados")
/**
 *  Recurso estado
 *  @author Pablo
 *
 */
public class EstadoRestController {


	@Autowired
	private EstadoService service;
	
	/**
	 * Obtiene una estado a través de su id.
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Estado> getById(@PathVariable Long id) throws Exception
	{
		Optional<Estado> rta=service.getById(id);
		if(rta.isPresent())
		{
			Estado pojo=rta.get();
			return new ResponseEntity<Estado>(pojo, HttpStatus.OK);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
}
