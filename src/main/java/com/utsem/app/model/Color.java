package com.utsem.app.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreJonatanMG;

    @Column(unique = true, length = 36)
    private UUID uuid;

    @PrePersist
    public void generarUUID() {
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreJonatanMG() {
		return nombreJonatanMG;
	}

	public void setNombreJonatanMG(String nombreJonatanMG) {
		this.nombreJonatanMG = nombreJonatanMG;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

  
}