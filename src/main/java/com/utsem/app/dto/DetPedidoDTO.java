package com.utsem.app.dto;

import java.util.UUID;

import com.utsem.app.model.DetProducto;
import com.utsem.app.model.Pedido;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DetPedidoDTO {

    @NotNull(message="La cantidad es obligatoria")
    @Min(value=1,message="La cantidad debe ser mayor a 0")
    private Integer cantidad;

    @NotNull(message="Precio obligatorio")
    @Min(value=1,message="Precio inválido")
    private Float precioUnitario;

    @NotNull(message="Subtotal obligatorio")
    @Min(value=1,message="Subtotal inválido")
    private Float subtotal;

    @NotBlank(message="Campo obligatorio")
    private String JoselynSC;

    @NotNull(message="Seleccione un pedido")
    private Pedido pedido;

    @NotNull(message="Seleccione un producto")
    private DetProducto detProducto;

    private UUID uuid;

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