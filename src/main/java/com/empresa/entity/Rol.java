package com.empresa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRol")
	private Integer idRol;

	@Column(name = "nombre", length = 45)
	private String nombre;

	@Column(name = "estado", length = 45)
	private String estado;
}