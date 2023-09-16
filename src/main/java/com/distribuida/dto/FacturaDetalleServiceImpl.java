package com.distribuida.dto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.dao.FacturaDetalleDAO;
import com.distribuida.dao.ProductoDAO;
import com.distribuida.entities.Factura;
import com.distribuida.entities.FacturaDetalle;
import com.distribuida.entities.Producto;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {
	
	@Autowired
	private FacturaDetalleDAO facturaDetalleDAO;
	
	@Autowired
	private FacturaDAO facturaDAO;
	
	@Autowired
	private ProductoDAO productoDAO;

	@Override
	public List<FacturaDetalle> findAll() {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.findAll();
	}

	@Override
	public FacturaDetalle findOne(int id) {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.findOne(id);
	}

	@Override
	public void add(FacturaDetalle facturaDetalle) {
		// TODO Auto-generated method stub
		facturaDetalleDAO.add(facturaDetalle);

	}

	@Override
	public void up(FacturaDetalle facturaDetalle) {
		// TODO Auto-generated method stub
		facturaDetalleDAO.up(facturaDetalle);

	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		facturaDetalleDAO.del(id);

	}

	@Override
	public void add(int idFacturaDetalle, int cantidad, double subtotal, int idFactura, int idProducto) {
		// TODO Auto-generated method stub
		Factura facturas = facturaDAO.findOne(idFactura);
		Producto producto = productoDAO.findOne(idProducto);
		
		FacturaDetalle facturaDetalle  = new FacturaDetalle(idFacturaDetalle, cantidad, subtotal);
		
		facturaDetalle.setFactura(facturas);
		facturaDetalle.setProducto(producto);
		
		facturaDetalleDAO.add(facturaDetalle);

	}

	@Override
	public void up(int idFacturaDetalle, int cantidad, double subtotal, int idFactura, int idProducto) {
		// TODO Auto-generated method stub
		Factura facturas = facturaDAO.findOne(idFactura);
		Producto producto = productoDAO.findOne(idProducto);
		
		FacturaDetalle facturaDetalle  = new FacturaDetalle(idFacturaDetalle, cantidad, subtotal);
		
		facturaDetalle.setFactura(facturas);
		facturaDetalle.setProducto(producto);
		
		facturaDetalleDAO.up(facturaDetalle);

	}

	@Override
	public void imprimir(List<FacturaDetalle> facturaDetalle) {
		// TODO Auto-generated method stub
		facturaDetalle.forEach(item ->{
			System.out.println(item);
		});

	}

}
