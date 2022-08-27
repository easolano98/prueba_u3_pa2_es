package com.uce.edu.demo.repository.modelo;

public class ProductoSencilloStock {
	private String codigo;
	private String nombre;
	private String categoria;
	private Integer stock;
	
	public ProductoSencilloStock(String codigo, String nombre, String categoria, Integer stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
		this.stock = stock;
	}
	
	public ProductoSencilloStock() {
		
	}
	
	

	@Override
	public String toString() {
		return "ProductoSencilloStock [codigo=" + codigo + ", nombre=" + nombre + ", categoria=" + categoria
				+ ", stock=" + stock + "]";
	}
	
	//SET y GET


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	//SET y GET
	
	
	
}
