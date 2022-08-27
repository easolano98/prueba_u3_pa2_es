package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.repository.modelo.ProductoSencilloStock;
@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {
	

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Producto buscar(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Producto>query=this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigo=:datoCodigo", Producto.class);
		query.setParameter("datoCodigo", codigo);
		return query.getSingleResult();
	}
	
	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public ProductoSencilloStock buscarNative(String codigo) {
		// TODO Auto-generated method stub
		Query query=this.entityManager.createNativeQuery("SELECT * FROM producto WHERE prod_codigo= :datoProducto", Producto.class);
		query.setParameter("datoProducto", codigo);
		return (ProductoSencilloStock) query.getSingleResult();
	}
	
	
	
	

}
