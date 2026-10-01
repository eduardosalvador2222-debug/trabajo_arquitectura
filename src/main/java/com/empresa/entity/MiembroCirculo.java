package com.empresa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "miembro_circulo")
public class MiembroCirculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_miembro_circulo")
    private Integer idMiembroCirculo;

    @ManyToOne
    @JoinColumn(name = "id_circulo")
    private CirculoConfianza circulo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "tipo_miembro")
    private String tipoMiembro;

    @Column(name = "comparte_ubicacion")
    private Boolean comparteUbicacion;

    @Column(name = "vinculado_en")
    private LocalDateTime vinculadoEn;

    @Column(name = "retirado_en")
    private LocalDateTime retiradoEn;
}