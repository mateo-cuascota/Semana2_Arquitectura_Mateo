package com.udla.arquitectura.demo.service;

import com.udla.arquitectura.demo.model.Producto;

import java.util.List;

/**
 * Abstraccion del servicio de productos.
 *
 * Tanto la implementacion real como el proxy utilizan esta interfaz. De esta
 * forma, el controlador no conoce si esta hablando directamente con la logica
 * de negocio o con el intermediario que agrega la cache.
 */
public interface ProductoService {

    List<Producto> listarTodos();

    Producto buscarPorId(Long id);
}
