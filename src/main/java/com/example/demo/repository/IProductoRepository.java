package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Producto;

public interface IProductoRepository {

	public void crear(Producto producto);

	public Producto seleccionar(Integer id);

	public Producto seleccionarcodigo(String codigo);

	public void eliminar(Integer id);

	public void actualizar(Producto producto);

	public List<Producto> seleccionartodos();

}
