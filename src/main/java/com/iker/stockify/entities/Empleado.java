package com.iker.stockify.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Clase entidad empleado
 */
@Entity
@Table(name = "empleados")
@Getter
@Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String email;
    private String password;
    private Role role;
    private boolean cuenta_activa;
    private LocalDate fecha_incorporacion;

    public Empleado() { }

    public Empleado(String nombre, String apellidos, String usuario, String email, String password, Role role, boolean cuenta_activa, LocalDate fecha_incorporacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.role = role;
        this.cuenta_activa = cuenta_activa;
        this.fecha_incorporacion = fecha_incorporacion;
    }
}
