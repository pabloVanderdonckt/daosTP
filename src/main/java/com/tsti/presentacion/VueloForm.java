package com.tsti.presentacion;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsti.entidades.Vuelo;
import com.tsti.entidades.Estado;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Objeto necesario para insertar o eliminar un cliente. 
 *
 */
public class VueloForm {


	@NotNull(message = "el id no puede ser nulo")
	@Min(1)
	private Long id;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaYhora;
	@NotNull
	private Long nuneroFilas;
	@NotNull
	private Long nuneroAsientos;
	@NotNull
	private String tipoVuelo;
	@NotNull
	@Size(min=2, max=30, message = "destino: bebe tener 2-30 letras")
	private String destino;
	@NotNull
	private String origen;
	@NotNull(message = "el idEstado no puede ser nulo")
	private long idEstado;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaYhora() {
		return fechaYhora;
	}
	public void setFechaYhora(Date fechaYhora) {
		this.fechaYhora = fechaYhora;
	}
	
	public long getNuneroFilas() {
		return nuneroFilas;
	}
	public void setNuneroFilas(long nuneroFilas) {
		this.nuneroFilas = nuneroFilas;
	}
	
	public long getNuneroAsientos() {
		return nuneroAsientos;
	}
	public void setNuneroAsientos(long nuneroAsientos) {
		this.nuneroAsientos = nuneroAsientos;
	}
	
	public String getTipoVuelo() {
		return tipoVuelo;
	}
	public void setTipoVuelo(String tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	
	public long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}
	
	
	
	public Vuelo toPojo()
	{
		Vuelo v = new Vuelo();
		v.setId(this.getId());
		v.setFechaYhora(this.getFechaYhora());
		v.setNuneroFilas(this.getNuneroFilas());
		v.setNuneroAsientos(this.getNuneroAsientos());
		v.setTipoVuelo(this.getTipoVuelo());
		v.setDestino(this.getDestino());
		v.setOrigen(this.getOrigen());
		return v;
	}
	
}
