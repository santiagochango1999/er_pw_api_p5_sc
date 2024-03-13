package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IProductoService;
import com.example.demo.service.TO.ProductoTO;
import com.example.demo.service.TO.ProductoparteTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping("/productos")
public class ProductoControllerResful {

	@Autowired
	private IProductoService iProductoService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crear(@RequestBody ProductoTO p) {
		this.iProductoService.crear(p);

	}

	@DeleteMapping(path = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		System.out.println("hola");
		this.iProductoService.eliminar(id);
	}

	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody ProductoTO p, @PathVariable Integer id) {
		p.setId(id);
		this.iProductoService.actualizar(p);

	}

	@GetMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoTO> consultar(@PathVariable String codigo) {
		ProductoTO to = this.iProductoService.seleccionarcodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(to);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoparteTO>> consultartodos() {
		List<ProductoparteTO> list = this.iProductoService.seleccionartodos();
		for (ProductoparteTO p : list) {
			Link link = linkTo(methodOn(ProductoControllerResful.class).consultar(p.getCodigoBarras())).withSelfRel();
			p.add(link);
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

}
