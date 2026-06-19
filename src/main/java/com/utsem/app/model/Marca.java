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

}
