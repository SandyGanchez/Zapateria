package com.utsem.app.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.utsem.app.model.Cliente;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PedidoDTO {

    @NotNull(message="La fecha es obligatoria")
    private LocalDate fechaPedido;

    @NotNull(message="El total es obligatorio")
    @Min(value = 1, message = "El total debe ser mayor a 0")
    private Float total;

    @NotBlank(message="Campo obligatorio")
    private String JoselynSC;

    @NotNull(message="Debe seleccionar un cliente")
    private Cliente cliente;

    private UUID uuid;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}