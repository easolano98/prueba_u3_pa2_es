package com.uce.edu.demo.repository.modelo;

public class ProductoSencillo {
	
	private String codigo;
	private Integer cantidad;
	
	public ProductoSencillo() {
		
	}
	
	public ProductoSencillo(String codigo, Integer cantidad) {
		this.codigo=codigo;
		this.cantidad=cantidad;
		
	}
	
	
	@Override
	public String toString() {
		return "ProductoSencillo [codigo=" + codigo + ", cantidad=" + cantidad + "]";
	}

	//SET y GET
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
