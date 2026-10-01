package com.udla.arquitectura.demo.service;

import com.udla.arquitectura.demo.model.Producto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Proxy del servicio de productos.
 *
 * El controlador depende de ProductoService, pero Spring inyecta esta clase
 * porque es el bean marcado como @Primary. El proxy revisa la cache antes de
 * delegar en ProductoServiceImpl. Por eso, la primera consulta tiene la
 * latencia simulada y las siguientes consultas pueden responder de inmediato.
 */
@Primary
@Service
public class ProductoServiceProxy implements ProductoService {

    private final ProductoServiceImpl servicioReal;

    public ProductoServiceProxy(ProductoServiceImpl servicioReal) {
        this.servicioReal = servicioReal;
    }

    /**
     * La lista se guarda con una unica entrada en la cache "productos".
     */
    @Override
    @Cacheable("productos")
    public List<Producto> listarTodos() {
        return servicioReal.listarTodos();
    }

    /**
     * Cada id funciona como una clave diferente dentro de la cache.
     */
    @Override
    @Cacheable(value = "productoPorId", key = "#id")
    public Producto buscarPorId(Long id) {
        return servicioReal.buscarPorId(id);
    }
}
