package com.iker.stockify.repositories;

import com.iker.stockify.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByEmail(String email);

    Optional<Empleado> findByUsername(String username);

    @Query("SELECT u.role FROM Empleado u WHERE u.email = ?1")
    Optional<String> getRoleByEmail(String email);

    boolean existsByEmail(String email);

}
