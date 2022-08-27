package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencilloStock;


@Service
public class ProductoServiceImpl implements IProductoService {
	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void ingresarProducto(Producto producto) {
		// TODO Auto-generated method stub
		try {
			Producto productoExistente=this.productoRepository.buscar(producto.getCodigo());
			productoExistente.setStock(productoExistente.getStock()+producto.getStock());
			this.productoRepository.actualizar(productoExistente);
		}catch (Exception e) {
			this.productoRepository.insertar(producto);
		}
	}

	@Override
	public ProductoSencilloStock consultarStock(String codigo) {
		// TODO Auto-generated method stub
		
		return this.productoRepository.buscarNative(codigo);
	}
	
	
}
