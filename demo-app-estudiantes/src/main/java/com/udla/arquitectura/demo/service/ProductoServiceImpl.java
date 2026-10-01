package com.udla.arquitectura.demo.service;

import com.udla.arquitectura.demo.model.Producto;
import com.udla.arquitectura.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementacion real de la logica de productos.
 *
 * Esta clase delega al repositorio, que simula una fuente de datos lenta.
 * El controlador no la utiliza directamente: las llamadas pasan primero por
 * ProductoServiceProxy.
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listarTodos() {
        return productoRepository.listarTodos();
    }

    @Override
    public Producto buscarPorId(Long id) {
        return productoRepository.buscarPorId(id);
    }
}
