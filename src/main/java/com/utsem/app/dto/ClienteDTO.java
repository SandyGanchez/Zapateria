package com.utsem.app.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {

    @NotBlank(message="El nombre es obligatorio")
    private String nombreMarthaAngelinaSL;

    @NotBlank(message="El teléfono es obligatorio")
    private String telefono;

    @NotBlank(message="El correo es obligatorio")
    private String correo;

    @NotBlank(message="La dirección es obligatoria")
    private String direccion;

    private UUID uuid;

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