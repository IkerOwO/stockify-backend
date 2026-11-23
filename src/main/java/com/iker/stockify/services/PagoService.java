package com.iker.stockify.services;

import com.iker.stockify.entities.Pago;
import com.iker.stockify.repositories.PagoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagoService {
    private final PagoRepository repository;

    public PagoService(PagoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Pago> getByPaymentType(String tipoPago) {
        return repository.getByTipo_pago(tipoPago);
    }
}
