package com.utsem.app.dto;


import com.utsem.app.model.Color;
import java.util.UUID;


import com.utsem.app.model.Producto;

public class DetProductoDTO {

	
	private Float talla;
	private Integer existencias;
	private Color color;
	private String descripcion;
	 private Producto producto;
	    private UUID uuid;
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
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
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
}
