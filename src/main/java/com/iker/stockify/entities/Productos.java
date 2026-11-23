package com.iker.stockify.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    private String nombre;
    private String descripcion;
    private String sku;
    private String codigo_barras;
    private Categoria categoria;
    private double precio_compra;
    private double precio_venta;
    private int cantidad_disponible;
    private int stock_minimo;

    public Productos() { }

    public Productos(String nombre, String descripcion, String sku, String codigo_barras,
                     Categoria categoria, double precio_compra, double precio_venta, int cantidad_disponible,
                     int stock_minimo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sku = sku;
        this.codigo_barras = codigo_barras;
        this.categoria = categoria;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.cantidad_disponible = cantidad_disponible;
        this.stock_minimo = stock_minimo;
    }
}
