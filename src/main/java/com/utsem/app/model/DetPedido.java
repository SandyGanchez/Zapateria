package com.utsem.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import java.util.UUID;

@Entity
public class DetPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Integer cantidad;
	@Column
	private Float precioUnitario;
	@Column
	private Float subtotal;
	@Column
	private String JoselynSC;
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private DetProducto detProducto;
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
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}
	public String getJoselynSC() {
		return JoselynSC;
	}
	public void setJoselynSC(String joselynSC) {
		JoselynSC = joselynSC;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public DetProducto getDetProducto() {
		return detProducto;
	}
	public void setDetProducto(DetProducto detProducto) {
		this.detProducto = detProducto;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}
