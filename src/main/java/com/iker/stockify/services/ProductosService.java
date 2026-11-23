package com.iker.stockify.services;

import com.iker.stockify.repositories.ProductosRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {
    private final ProductosRepository repository;

    public ProductosService(ProductosRepository repository) {
        this.repository = repository;
    }


}
