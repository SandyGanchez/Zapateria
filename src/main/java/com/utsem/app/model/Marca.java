package com.utsem.app.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Marca {
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
    @Column
    private String nombreMarthaASL;
    @Column
    private String descripcion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreMarthaASL() {
		return nombreMarthaASL;
	}
	public void setNombreMarthaASL(String nombreMarthaASL) {
		this.nombreMarthaASL = nombreMarthaASL;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
