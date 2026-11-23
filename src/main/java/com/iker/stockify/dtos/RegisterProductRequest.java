package com.iker.stockify.dtos;

import com.iker.stockify.entities.Categoria;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterProductRequest {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String sku;
    @NotBlank
    private String codigo_barras;
    private Categoria categoria;
    private double precio_compra;
    private double precio_venta;
    private int cantidad_disponible;
    private int stock_minimo;
}
