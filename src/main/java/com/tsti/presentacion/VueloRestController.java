package com.tsti.presentacion;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsti.dto.VueloResponseDTO;
import com.tsti.entidades.Ciudad;
import com.tsti.entidades.Estado;
import com.tsti.entidades.Vuelo;

import com.tsti.exception.Excepcion;
import com.tsti.presentacion.error.MensajeError;
import com.tsti.servicios.EstadoService;
import com.tsti.servicios.VueloService;

import jakarta.validation.Valid;
/**
 * Recurso Vuelo
 * @author Pablo
 *
 */
@RestController
@RequestMapping("/vuelos")
public class VueloRestController {
	
	@Autowired
	private VueloService service; 
	
	@Autowired
	private EstadoService EstadoService;
	
	/**
	 * Permite filtrar Vuelos.
	 * @param destino
	 * @return
	 * @throws Excepcion 
	 */
	@GetMapping( produces = { MediaType.APPLICATION_JSON_VALUE})
	public List<VueloResponseDTO> filtrarVuelos(@RequestParam(name = "destino",required = false) String destino) throws Excepcion {
		
		List<Vuelo> vuelo = service.filtrar(destino);
		List<VueloResponseDTO> dtos=new ArrayList<VueloResponseDTO>();
		for (Vuelo pojo : vuelo) {
			
	        dtos.add(buildResponse(pojo));
		}
		return dtos;

	}
	
	

	/**
	 * @param id DNI del cliente buscada
	 * @return Cliente encontrado o Not found en otro caso
	 * @throws Excepcion 
	 */
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<VueloResponseDTO> getById(@PathVariable Long id) throws Excepcion
	{
		Optional<Vuelo> rta = service.getById(id);
		if(rta.isPresent())
		{
			Vuelo pojo=rta.get();
			return new ResponseEntity<VueloResponseDTO>(buildResponse(pojo), HttpStatus.OK);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	
	
	//Ver
	/**
	 * Crea un cliente con el dni indicado y los parametros pasados
	 * @param c Clientes  a insertar
	 * @return Cliente insertado o error en otro caso
	 * @throws Exception 
	 */
	@PostMapping
	public ResponseEntity<Object> guardar( @Valid @RequestBody VueloForm form, BindingResult result) throws Exception
	{
		
		if(result.hasErrors())
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( this.formatearError(result));
		}
		
		Vuelo v = form.toPojo();
		v.setOrigen("Origen");
		
		//ahora inserto el cliente
		service.insert(v);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(v.getId()).toUri(); //Por convención en REST, se devuelve la  url del recurso recién creado

		//return ResponseEntity.created(location).build();//201 (Recurso creado correctamente)
		return ResponseEntity.ok(buildResponse(v));
		

	}
	
	
	
	/**
	 * Actualiza el cliente con el dni indicado y los parametros pasados
	 * @param c Cliente a modificar
	 * @return Client6e Editado o error en otro caso
	 * @throws Excepcion 
	 */
	@PutMapping("/{dni}")
	public ResponseEntity<Object>  actualizar(@RequestBody VueloForm form, @PathVariable long id) throws Exception
	{
		Optional<Vuelo> rta = service.getById(id);
		if(!rta.isPresent())
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra el cliente que desea modificar.");
			
		else
		{
			Vuelo v = form.toPojo();
			Optional<Estado> e = EstadoService.getById(form.getIdEstado());
			if(e.isPresent())
				v.setEstado(e.get());
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getError("02", "Ciudad Requerida", "La ciudad indicada no se encuentra en la base de datos."));
			if(!v.getId().equals(id))//El dni es el identificador, con lo cual es el único dato que no permito modificar
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getError("03", "Dato no editable", "Noi puede modificar el dni."));
			service.update(v);
			return ResponseEntity.ok(buildResponse(v));
		}
		
	}
	

	
	
	//Funciona
	/**
	 * Borra el cliente con el dni indicado
	 * @param dni Dni de la cliente a borrar
	 * @return ok en caso de borrar exitosamente al cliente, error en otro caso
	 */
	@DeleteMapping("/{dni}")
	public ResponseEntity<String> eliminar(@PathVariable Long id)
	{
		if(!service.getById(id).isPresent())
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un cliente con ese dni");
		service.delete(id);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	
	
	private VueloResponseDTO buildResponse(Vuelo pojo) throws Excepcion {
		try {
			VueloResponseDTO dto = new VueloResponseDTO(pojo);
			 //Self link
			Link selfLink = WebMvcLinkBuilder.linkTo(VueloRestController.class)
										.slash(pojo.getId())                
										.withSelfRel();
			dto.add(selfLink);
			
			return dto;
		} catch (Exception e) {
			throw new Excepcion(e.getMessage(), 500);
		}
	}
	
	private String formatearError(BindingResult result) throws JsonProcessingException
	{
//		primero transformamos la lista de errores devuelta por Java Bean Validation
		List<Map<String, String>> errores= result.getFieldErrors().stream().map(err -> {
															Map<String, String> error= new HashMap<>();
															error.put(err.getField(),err.getDefaultMessage() );
															return error;
														}).collect(Collectors.toList());
		MensajeError e1=new MensajeError();
		e1.setCodigo("01");
		e1.setMensajes(errores);
		
		//ahora usamos la librería Jackson para pasar el objeto a json
		ObjectMapper maper = new ObjectMapper();
		String json = maper.writeValueAsString(e1);
		return json;
	}
	
	private String getError(String code, String err, String descr) throws JsonProcessingException
	{
		MensajeError e1=new MensajeError();
		e1.setCodigo(code);
		ArrayList<Map<String,String>> errores=new ArrayList<>();
		Map<String, String> error=new HashMap<String, String>();
		error.put(err, descr);
		errores.add(error);
		e1.setMensajes(errores);
		
		//ahora usamos la librería Jackson para pasar el objeto a json
				ObjectMapper maper = new ObjectMapper();
				String json = maper.writeValueAsString(e1);
				return json;
	}

}
