package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.repository.modelo.ProductoSencilloStock;
import com.uce.edu.demo.repository.modelo.ReporteSencillo;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.IVentaService;

@SpringBootApplication
public class PruebaU3Pa2EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(PruebaU3Pa2EsApplication.class);
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IVentaService ventaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaU3Pa2EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		List<ProductoSencillo> carrito = new ArrayList<ProductoSencillo>();
		Producto producto=new Producto();

		producto.setNombre("Arroz Osito");
		producto.setCodigo("0103");
		producto.setCategoria("Granos");
		producto.setStock(10);
		producto.setPrecio(new BigDecimal(10.50));

		this.productoService.ingresarProducto(producto);
		this.productoService.ingresarProducto(producto);
		
		ProductoSencillo productoCarrito=new ProductoSencillo();
		productoCarrito.setCodigo("0103");
		productoCarrito.setCantidad(4);
		
		carrito.add(productoCarrito);
		
		this.ventaService.realizarVenta(carrito, "1715202330", "F001");
		

		//ProductoSencilloStock productoStock= this.productoService.consultarStock("0103");
		//LOGGER.info("Consulta Producto----> "+productoStock);
		
		
		List<ReporteSencillo> listaReporte = this.ventaService.GenerarReporteVentas(LocalDateTime.of(2022, 8, 26, 0, 0), "Aseo", 4);
		listaReporte.forEach(reporte -> LOGGER.info("Reporte ------------> "+reporte));

	}

}
