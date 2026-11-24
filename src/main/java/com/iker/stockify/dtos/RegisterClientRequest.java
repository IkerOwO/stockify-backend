package com.iker.stockify.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterClientRequest {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellidos;
    @NotBlank
    private String domicilio;
    @NotBlank
    private String nombre_usuario;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String contrasenya;
}
