package com.distribuida.dto;

import java.util.List;

import com.distribuida.entities.FacturaDetalle;

public interface FacturaDetalleService {

	public List<FacturaDetalle> findAll();
	
	public FacturaDetalle findOne(int id); 
	
	public void add(FacturaDetalle facturaDetalle); 
	
	public void up(FacturaDetalle facturaDetalle); 
	
	public void del(int id);  
	
	
	public void add(int idFacturaDetalle, int cantidad, double subtotal, int idFactura, int idProducto);

	public void up(int idFacturaDetalle, int cantidad, double subtotal, int idFactura, int idProducto);
	
	public void imprimir(List<FacturaDetalle> facturaDetalle);

}
