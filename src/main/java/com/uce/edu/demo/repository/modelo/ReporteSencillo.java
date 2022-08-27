package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

public class ReporteSencillo {
	private String codigo;
    private String categoria;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
    
    public ReporteSencillo() {
    	
    }

	public ReporteSencillo(String codigo, String categoria, Integer cantidad, BigDecimal precioUnitario,
			BigDecimal subtotal) {
		super();
		this.codigo = codigo;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
	}
	
	
    @Override
	public String toString() {
		return "ReporteSencillo [codigo=" + codigo + ", categoria=" + categoria + ", cantidad=" + cantidad
				+ ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + "]";
	}

	//SET y GET
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
   
	
}
