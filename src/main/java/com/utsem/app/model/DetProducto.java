package com.utsem.app.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class DetProducto {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Float talla;
    @Column
	private Integer existencias;
    @ManyToOne
    private Color color;
	@Column
    private String descripcion;
	  @ManyToOne
	    private Producto producto;
    @Column(unique=true)
    private UUID uuid;
	@PrePersist
	private void inicializarUuid() {
		this.uuid=UUID.randomUUID();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getTalla() {
		return talla;
	}
	public void setTalla(Float talla) {
		this.talla = talla;
	}
	public Integer getExistencias() {
		return existencias;
	}
	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	 public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
		}
	

}
