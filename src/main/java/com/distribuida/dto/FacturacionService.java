package com.distribuida.dto;

import java.util.Date;
import java.util.List;

import com.distribuida.entities.Factura;
import com.distribuida.entities.FacturaDetalle;

public interface FacturacionService {

	public List<FacturaDetalle> findAll();
	
	public Factura findOne(int id);
	
	public void addFactura(int idFactura, String numFactura, Date fecha, double totalNeto, double iva, double total, int idCliente);
	
	public void addDetalle(int idFacturaDetalle, int cantidad, double subtotal, int idFactura, int idProducto);	
	
	public int findMax();
}
