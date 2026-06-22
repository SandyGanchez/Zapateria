package com.utsem.app.dto;

import jakarta.validation.constraints.NotBlank;

public class ColorDTO {

	private Long id;

    @NotBlank(message = "El nombre del color es obligatorio")
    private String nombreJonatanMG;

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
}