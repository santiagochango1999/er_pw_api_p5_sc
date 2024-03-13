package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.model.Producto;
import com.example.demo.service.TO.ProductoTO;
import com.example.demo.service.TO.ProductoparteTO;

@Service
public class ProductoServiceImpl implements IProductoService {
	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public void crear(ProductoTO producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.crear(this.convertir1(producto));

	}

	@Override
	public ProductoTO seleccionarcodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.convertir(this.iProductoRepository.seleccionarcodigo(codigo));
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iProductoRepository.eliminar(id);

	}

	@Override
	public void actualizar(ProductoTO producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(this.convertir1(producto));

	}

	@Override
	public List<ProductoparteTO> seleccionartodos() {
		// TODO Auto-generated method stub

		List<Producto> list = this.iProductoRepository.seleccionartodos();
		List<ProductoparteTO> listto = new ArrayList<>();
		for (Producto p : list) {
			ProductoparteTO to = this.convertir2(p);
			listto.add(to);

		}
		return listto;
	}

	private ProductoTO convertir(Producto p) {
		ProductoTO to = new ProductoTO();
		to.setId(p.getId());
		to.setCodigoBarras(p.getCodigoBarras());
		to.setNombre(p.getNombre());
		to.setFechaCaducidad(p.getFechaCaducidad());
		to.setStock(p.getStock());
		return to;
	}

	private Producto convertir1(ProductoTO p) {
		Producto to = new Producto();
		to.setId(p.getId());
		to.setCodigoBarras(p.getCodigoBarras());
		to.setNombre(p.getNombre());
		to.setFechaCaducidad(p.getFechaCaducidad());
		to.setStock(p.getStock());
		return to;
	}

	private ProductoparteTO convertir2(Producto p) {
		ProductoparteTO to = new ProductoparteTO();
		to.setCodigoBarras(p.getCodigoBarras());
		to.setNombre(p.getNombre());
		return to;
	}
}
