package com.utsem.app.dto;

import java.util.UUID;

import com.utsem.app.enums.Estatus;

import com.utsem.app.model.Marca;

public class ProductoDTO {
	private String nombreSandraSG;
	private String descripcion;
	private Float precio;
	private String imagen;
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	private Estatus estatus;
	private Marca marca;
	
	private UUID uuid;
	public String getNombreSandraSG() {
		return nombreSandraSG;
	}
	public void setNombreSandraSG(String nombreSandraSG) {
		this.nombreSandraSG = nombreSandraSG;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Estatus getEstatus() {
		return estatus;
	}
	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	
	
}
