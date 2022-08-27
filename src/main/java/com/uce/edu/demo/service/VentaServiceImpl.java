package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleVentaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.repository.modelo.ReporteSencillo;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class VentaServiceImpl implements IVentaService {
	@Autowired
	private IVentaRepository ventaRepository;

	@Autowired
	private IDetalleVentaRepository detalleVentaRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarVenta(List<ProductoSencillo> listaProd, String cedulaCliente, String numeroVenta) {
		// TODO Auto-generated method stub
		List<DetalleVenta> detalles = new ArrayList<>();
		BigDecimal pagoTotal = new BigDecimal(0);

		Venta venta = new Venta();
		venta.setCedulaCliente(cedulaCliente);
		venta.setNumero(numeroVenta);
		venta.setFecha(LocalDateTime.now());

		for (ProductoSencillo codigoProducto : listaProd) {
			DetalleVenta detaVenta = new DetalleVenta();
			detaVenta.setVenta(venta);
			detaVenta.setCantidad(codigoProducto.getCantidad());

			Producto productoBuscado = this.productoRepository.buscar(codigoProducto.getCodigo());

			if (productoBuscado.getStock() >= detaVenta.getCantidad()) {
				detaVenta.setProducto(productoBuscado);
				detaVenta.setPrecioUnitario(productoBuscado.getPrecio());
				detaVenta.setSubtotal(
						new BigDecimal(codigoProducto.getCantidad()).multiply(productoBuscado.getPrecio()));

				productoBuscado.setStock(productoBuscado.getStock() - detaVenta.getCantidad());
				this.productoRepository.actualizar(productoBuscado);
				detalles.add(detaVenta);
				pagoTotal = pagoTotal.add(detaVenta.getSubtotal());

			} else {
				throw new RuntimeException();
			}

		}
		venta.setDetalles(detalles);
		venta.setTotal(pagoTotal);
		this.ventaRepository.insertar(venta);

	}

	@Override
	public List<ReporteSencillo> GenerarReporteVentas(LocalDateTime fecha, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub

		List<DetalleVenta> detalles = this.detalleVentaRepository.buscar(fecha);

		IReporteUnary<ReporteSencillo, ReporteSencillo> reporteLambda = reporte -> {
			if (reporte.getCategoria().equals(categoria)) {
				if (reporte.getCantidad() >= cantidad) {
					return reporte;
				}
			} else {

				return null;
			}
			return null;
		};
		List<ReporteSencillo> reportesList = new ArrayList<ReporteSencillo>();
		for (DetalleVenta detalleVenta : detalles) {
			ReporteSencillo reporte = new ReporteSencillo();
			reporte.setCantidad(detalleVenta.getCantidad());
			reporte.setPrecioUnitario(detalleVenta.getPrecioUnitario());
			reporte.setSubtotal(detalleVenta.getSubtotal());
			reporte.setCategoria(detalleVenta.getProducto().getCategoria());
			reporte.setCodigo(detalleVenta.getProducto().getCodigo());

			ReporteSencillo reporteUnary = reporteLambda.aplicar(reporte);
			if (reporteUnary != null) {
				reportesList.add(reporteUnary);
			}
		}

		return reportesList;
	}
}
