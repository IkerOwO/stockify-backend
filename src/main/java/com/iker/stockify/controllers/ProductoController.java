package com.iker.stockify.controllers;

import com.iker.stockify.dtos.RegisterProductRequest;
import com.iker.stockify.entities.Categoria;
import com.iker.stockify.entities.Productos;
import com.iker.stockify.services.ProductosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductoController {
    private final ProductosService service;

    public ProductoController(ProductosService service) {
        this.service = service;
    }

    @GetMapping("/{categoria}")
    public List<Productos> getAllByCategorias(@PathVariable Categoria categoria) {
        return service.getAllByCategorias(categoria);
    }

    @GetMapping("/{codigoBarras}")
    public Optional<Productos> getByCodigoDeBarras(@PathVariable String codigoBarras){
        return service.getByCodigoDeBarras(codigoBarras);
    }

    @GetMapping("/stockMinimo")
    public List<Productos> getByStockMinimo() {
        return service.getByStockMinimo();
    }

    @PostMapping("/insertProduct")
    public ResponseEntity<?> insertNewProduct(@Valid @RequestBody RegisterProductRequest request) {
        service.insertNewProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{codigoBarras}/stock")
    public ResponseEntity<?> updateStock(@Valid @RequestBody int newStock, @PathVariable String codigoBarras) {
        service.updateStock(newStock, codigoBarras);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{codigoBarras}")
    public ResponseEntity<?> deleteProduct(@PathVariable String codigoBarras) {
        service.deleteProduct(codigoBarras);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
