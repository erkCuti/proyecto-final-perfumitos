package com.distribuida.dto;

import java.util.Date;
import java.util.List;

import com.distribuida.entities.Categoria;
import com.distribuida.entities.Factura;

public interface FacturaService {
	
	public List<Factura> findAll();
	
	public List<Factura> findAll(String busqueda);
	
	public Factura findOne(int id); 
	
	public void add(Factura factura);
	
	public void up(Factura factura); 
	
	public void del(int id);  
	
	
	public void add(int idFactura, String numFactura, Date fecha, double totalNeto, double iva, double total, int idCliente);

	public void up(int idFactura, String numFactura, Date fecha, double totalNeto, double iva, double total, int idCliente);
	
	public void imprimir(List<Factura> factura);
	

}
