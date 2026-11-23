package com.iker.stockify.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase entidad Pago
 */
@Entity
@Table(name = "pagos")
@Getter
@Setter
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;
    private Tipos_pago tipo_pago;

    public Pago() { }

    public Pago(Tipos_pago tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
}
