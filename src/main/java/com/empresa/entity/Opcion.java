package com.empresa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "opcion")
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOpcion")
    private Integer idOpcion;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "estado", length = 45)
    private String estado;

    @Column(name = "ruta", columnDefinition = "TEXT")
    private String ruta;

    @Column(name = "tipo")
    private Short tipo;
}