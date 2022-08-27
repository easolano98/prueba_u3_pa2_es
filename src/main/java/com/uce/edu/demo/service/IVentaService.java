package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.repository.modelo.ReporteSencillo;



public interface IVentaService {
public void realizarVenta(List<ProductoSencillo>listaProd, String cedulaCliente, String numeroVenta);
	
	public List<ReporteSencillo> GenerarReporteVentas(LocalDateTime fecha,String categoria,Integer cantidad);
	
}
