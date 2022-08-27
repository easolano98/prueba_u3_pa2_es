package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

public interface IDetalleVentaRepository {
	public void insertar(DetalleVenta detalle);
	
	public List<DetalleVenta>buscar(LocalDateTime fecha);
}
