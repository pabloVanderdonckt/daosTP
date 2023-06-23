package com.tsti.presentacion;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsti.entidades.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Objeto necesario para insertar o eliminar un cliente. 
 *
 */
public class ClienteForm {


	@NotNull(message = "el dni no puede ser nulo")
	@Min(1)
	private Long dni;
	@NotNull
	@Size(min=2, max=30, message = "apellido: bebe tener 2-30 letras")
	private String apellido;
	@NotNull
	@Size(min=2, max=30, message = "nombre: bebe tener 2-30 letras")
	private String nombre;
	@NotNull
	@Size(min = 1,max = 50, message = "domicilio: bebe tener 2-50 letras")
	private String domicilio;
	
	@Email(message = "El e-mail ingresado no es valido")
	private String email;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date fechaNacimiento;
	@NotNull(message = "el nuneroPasaporte no puede ser nulo")
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
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
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
	
	public Cliente toPojo()
	{
		Cliente c = new Cliente();
		c.setDni(this.getDni());
		c.setApellido(this.getApellido());
		c.setNombre(this.getNombre());
		c.setDni(this.getDni());
		c.setDomicilio(this.getDomicilio());
		
		c.setEmail(this.getEmail());
		c.setFechaNacimiento(this.getFechaNacimiento());
		c.setNuneroPasaporte(this.getNuneroPasaporte());
		c.setFechaVencientoPasaporte(this.getFechaVencientoPasaporte());
		
		return c;
	}
	
}
