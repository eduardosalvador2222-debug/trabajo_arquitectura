package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ruta")
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    private Long idRuta;

    @ManyToOne
    @JoinColumn(name = "id_origen", nullable = false)
    private Lugar origen;

    @ManyToOne
    @JoinColumn(name = "id_destino", nullable = false)
    private Lugar destino;

    @Column(name = "id_modo_transporte", nullable = false)
    private Integer idModoTransporte;

    @Column(name = "distancia_estimada_m", nullable = false)
    private Double distanciaEstimadaM;

    @Column(name = "duracion_estimada_s", nullable = false)
    private Long duracionEstimadaS;

    @Column(name = "puntaje_seguridad", nullable = false)
    private Integer puntajeSeguridad;

    @Column(name = "calculada_en", nullable = false)
    private LocalDateTime calculadaEn = LocalDateTime.now();
}
