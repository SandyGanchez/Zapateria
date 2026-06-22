package com.utsem.app.model;

import java.util.UUID;

import com.utsem.app.enums.Estatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombreSandraSG;
    @Column
    private String descripcion;
    @Column
    private Float precio;
    @Column
    private Estatus estatus;
    @Column
    private String imagen;
   @ManyToOne
   private Marca marca;
  
  
   
    @Column(unique=true)
    private UUID uuid;
    
	@PrePersist
	private void inicializarUuid() {
		this.uuid=UUID.randomUUID();
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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