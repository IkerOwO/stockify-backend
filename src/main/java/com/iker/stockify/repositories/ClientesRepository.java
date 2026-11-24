package com.iker.stockify.repositories;

import com.iker.stockify.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    Optional<Clientes> findByemail(String email);

}
