package com.utsem.app.model;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombreMarthaAngelinaSL;
	@Column
	private String telefono;
	@Column
	private String correo;
	@Column
	private String direccion;
	@Column(unique = true)
	private UUID uuid;
	@PrePersist
	private void inicializarUuid() {
		this.uuid = UUID.randomUUID();
	}
	
	//Getters y Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreMarthaAngelinaSL() {
		return nombreMarthaAngelinaSL;
	}
	public void setNombreMarthaAngelinaSL(String nombreMarthaAngelinaSL) {
		this.nombreMarthaAngelinaSL = nombreMarthaAngelinaSL;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}
