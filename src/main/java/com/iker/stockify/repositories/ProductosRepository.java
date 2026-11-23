package com.iker.stockify.repositories;

import com.iker.stockify.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
    List<Productos> getByCategoria(String categoria);
    Optional<Productos> getByCodigoDeBarras(String codigoBarras);
    @Query("SELECT p FROM Productos p ORDER BY p.stock_minimo ASC")
    List<Productos> getByStock_minimo();
}
