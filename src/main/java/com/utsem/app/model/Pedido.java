package com.utsem.app.model;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.*;
import jakarta.persistence.PrePersist;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private LocalDate fechaPedido;
	@Column
	private Float total;
	@Column
	private String JoselynSC;
	@Column(unique = true)
	private UUID uuid;
	@ManyToOne
	private Cliente cliente;
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
	public LocalDate getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public String getJoselynSC() {
		return JoselynSC;
	}
	public void setJoselynSC(String joselynSC) {
		JoselynSC = joselynSC;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
