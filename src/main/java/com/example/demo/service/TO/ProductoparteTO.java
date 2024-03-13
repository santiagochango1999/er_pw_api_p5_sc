package com.example.demo.service.TO;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class ProductoparteTO extends RepresentationModel<ProductoparteTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1692436981686074032L;
	private String codigoBarras;
	private String nombre;

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
