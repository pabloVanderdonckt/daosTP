package com.tsti.entidades;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
public class Cliente {

	
	@Id
	private Long dni;
	
	@NotNull
	@Size(min = 1,max = 100, message = "Debe completar el apellido")
	private String apellido;
	
	@NotNull
	@Size(min = 1,max = 100, message = "Debe completar el nombre")
	private String nombre;
	
	@NotNull
	@Size(min = 1,max = 100, message = "Debe completar el domicilio")
	private String domicilio;
	
	@ManyToOne
	private Ciudad ciudad;
	
	@Email(message = "El e-mail ingresado no es valido")
	private String email;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaNacimiento;
	
	private Long nuneroPasaporte;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaVencientoPasaporte;
	
	
	
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
	
	@Override
	public String toString() {
		return dni+" - "+ nombre +" "+ apellido;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
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
	
	public Long getNuneroPasaportei() {
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
	
	
}
