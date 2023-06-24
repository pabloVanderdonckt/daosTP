package com.tsti.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import com.tsti.entidades.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Objeto utilizado para construir la respuesta de los servicios
 * 
 *
 */
public class ClienteResponseDTO extends RepresentationModel<ClienteResponseDTO> {

	private Long dni;
	private String apellido;
	private String nombre;
	private String domicilio;
	private String ciudad;
	private String email;
	private Date fechaNacimiento;
	private Long nuneroPasaporte;
	private Date fechaVencientoPasaporte;
	
	public ClienteResponseDTO(Cliente pojo) {
		super();
		this.apellido=pojo.getApellido();
		this.nombre=pojo.getNombre();
		this.dni=pojo.getDni();
		this.domicilio=pojo.getDomicilio();
		this.ciudad=pojo.getCiudad().getNombre();
		this.email=pojo.getEmail();
		this.fechaNacimiento=pojo.getFechaNacimiento();
		this.nuneroPasaporte=pojo.getNuneroPasaportei();
		this.fechaVencientoPasaporte=pojo.getFechaVencientoPasaporte();
		
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Long getNuneroPasaporte() {
		return nuneroPasaporte;
	}
	public void setNuneroPasaporte(Long nuneroPasaporte) {
		this.nuneroPasaporte = nuneroPasaporte;
	}
	
	public Date getFechaVencientoPasaporte() {
		return fechaVencientoPasaporte;
	}
	public void setFechaVencientoPasaporte(Date fechaVencientoPasaporte) {
		this.fechaVencientoPasaporte = fechaVencientoPasaporte;
	}
	
	
	@Override
	public String toString() {
		return dni+" - "+ nombre +" "+ apellido;
	}
	
}
