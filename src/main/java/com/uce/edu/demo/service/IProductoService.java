package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencilloStock;

public interface IProductoService {
	public void ingresarProducto(Producto producto);
	
	public ProductoSencilloStock consultarStock(String codigo);
	
}
