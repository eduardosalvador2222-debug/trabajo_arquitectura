package com.empresa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String nombres;
    private String apellidos;
    private String dni;
    private String login;
    private String password;
    private String correo;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaNacimiento;
    private String direccion;

    public String getNombreCompleto() {
        if (nombres != null && apellidos != null) {
            return nombres.concat(" ").concat(apellidos);
        } else {
            return "";
        }
    }
}
