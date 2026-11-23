package com.iker.stockify.repositories;

import com.iker.stockify.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> getBytipo_pago(String tipoPago);
}
