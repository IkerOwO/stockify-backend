package com.iker.stockify.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Clase entidad Clientes
 */
@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private String nombre_usuario;
    private String email;
    private String contrasenya;
    private boolean cuenta_activa;
    private LocalDate fecha_creacion_cuenta;

    public Clientes() { }

    public Clientes(String nombre, String apellidos, String domicilio,
                    String nombre_usuario, String email, String contrasenya, boolean cuenta_activa,
                    LocalDate fecha_creacion_cuenta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.contrasenya = contrasenya;
        this.cuenta_activa = cuenta_activa;
        this.fecha_creacion_cuenta = fecha_creacion_cuenta;
    }
}
