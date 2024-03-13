package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public Producto seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public Producto seleccionarcodigo(String codigo) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras=:codigo");
		query.setParameter("codigo", codigo);
		return (Producto) query.getSingleResult();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);

	}

	@Override
	public List<Producto> seleccionartodos() {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("SELECT p FROM Producto p");
		return query.getResultList();
	}

}
