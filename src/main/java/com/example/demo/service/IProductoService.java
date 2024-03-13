package com.example.demo.service;

import java.util.List;

import com.example.demo.service.TO.ProductoTO;
import com.example.demo.service.TO.ProductoparteTO;

public interface IProductoService {

	public void crear(ProductoTO producto);

	public ProductoTO seleccionarcodigo(String codigo);

	public void eliminar(Integer id);

	public void actualizar(ProductoTO producto);

	public List<ProductoparteTO> seleccionartodos();

}
