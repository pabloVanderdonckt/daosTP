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
public class Vuelo {
	
	
	@Id
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
	private String destino;
	
	@NotNull
	private String origen;
	
	@ManyToOne
	private Estado estado;

	
	
	
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
	
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
}
