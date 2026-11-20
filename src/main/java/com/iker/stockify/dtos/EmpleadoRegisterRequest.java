package com.iker.stockify.dtos;

import com.iker.stockify.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpleadoRegisterRequest {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellidos;
    @NotBlank
    private String username;
    @Size(min = 8)
    private String password;
    @NotBlank
    @Email
    private String email;
    private Role role;
    private boolean cuenta_activa;
    private LocalDate fecha_incorporacion;

}
