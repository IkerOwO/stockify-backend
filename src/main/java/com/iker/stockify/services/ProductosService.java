package com.iker.stockify.services;

import com.iker.stockify.dtos.RegisterProductRequest;
import com.iker.stockify.entities.Categoria;
import com.iker.stockify.entities.Productos;
import com.iker.stockify.exceptions.ProductAlreadyExistsException;
import com.iker.stockify.exceptions.ProductDoesntExistsException;
import com.iker.stockify.repositories.ProductosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {
    private final ProductosRepository repository;

    public ProductosService(ProductosRepository repository) {
        this.repository = repository;
    }

    public List<Productos> getAllByCategorias(Categoria categoria) {
        return repository.getByCategoria(categoria);
    }

    public Optional<Productos> getByCodigoDeBarras(String codigoBarras) {
        return repository.getBycodigo_barras(codigoBarras);
    }

    public List<Productos> getByStockMinimo() {
        return repository.getByStock_minimo();
    }

    public void insertNewProduct(RegisterProductRequest request) {
        Optional<Productos> opProduct = repository.findBycodigo_barras(request.getCodigo_barras());

        if (opProduct.isPresent()) {
            throw new ProductAlreadyExistsException("El producto ya existe en la base de datos!");
        }
        Productos producto = new Productos();
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setSku(request.getSku());
        producto.setCodigo_barras(request.getCodigo_barras());
        producto.setCategoria(request.getCategoria());
        producto.setPrecio_compra(request.getPrecio_compra());
        producto.setPrecio_venta(request.getPrecio_venta());
        producto.setStock_minimo(request.getStock_minimo());
        repository.save(producto);
    }

    @Transactional
    public void updateStock(int newStock, String codigoBarras) {
        Optional<Productos> opProducto = repository.findBycodigo_barras(codigoBarras);
        if (opProducto.isPresent()) {
            Productos producto = opProducto.get();
            producto.setStock_minimo(newStock);
            repository.save(producto);
        } else {
            throw new ProductDoesntExistsException("Producto no encontrado!");
        }
    }

    @Transactional
    public void deleteProduct(String codigoBarras) {
        Optional<Productos> opProducto = repository.findBycodigo_barras(codigoBarras);

        opProducto.ifPresentOrElse(
                p -> repository.delete(p),
                () -> System.out.println("Error al borrar el producto!")
        );
    }

}
