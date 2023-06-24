package com.tsti.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import com.tsti.entidades.Estado;
import com.tsti.entidades.Vuelo;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Objeto utilizado para construir la respuesta de los servicios
 * 
 *
 */
public class VueloResponseDTO extends RepresentationModel<VueloResponseDTO> {
	
	private Long id;
	private Date fechaYhora;
	private Long nuneroFilas;
	private Long nuneroAsientos;
	private String tipoVuelo;
	private String destino;
	private String origen;
	private String estado;

	public VueloResponseDTO(Vuelo pojo) {
		super();
		this.id=pojo.getId();
		this.fechaYhora=pojo.getFechaYhora();
		this.nuneroFilas=pojo.getNuneroFilas();
		this.nuneroAsientos=pojo.getNuneroAsientos();
		this.tipoVuelo=pojo.getTipoVuelo();
		this.destino=pojo.getDestino();
		this.origen=pojo.getOrigen();
		this.estado=pojo.getEstado().getNombre();
	}
	

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
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
		
}
