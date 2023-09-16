package com.distribuida.dto;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.dao.FacturaDetalleDAO;
import com.distribuida.dao.ProductoDAO;
import com.distribuida.entities.Cliente;
import com.distribuida.entities.Factura;
import com.distribuida.entities.FacturaDetalle;
import com.distribuida.entities.Producto;

@Service
public class FacturacionServiceImpl implements FacturacionService {

	@Autowired
	private FacturaDetalleDAO facturaDetalleDAO;
	
	@Autowired
	private FacturaDAO facturaDAO;
	
    @Autowired
    private ProductoDAO productoDAO;

    @Autowired
    private ClienteDAO clienteDAO;
	
	@Override
	public List<FacturaDetalle> findAll() {
		return facturaDetalleDAO.findAll();
	}

	@Override
	public Factura findOne(int id) {
		return facturaDAO.findOne(id);
	}

	@Override
	public void addFactura(int idFactura, String numFactura, Date fecha, double totalNeto, double iva, double total,
			int idCliente) {
		Cliente cliente = clienteDAO.findOne(idCliente);
		Factura factura = new Factura(idFactura, numFactura, fecha, totalNeto, iva, total);
			factura.setCliente(cliente);
		facturaDAO.add(factura);
	}

	@Override
	public void addDetalle(int idFacturaDetalle, int cantidad, double subtotal, int idFactura, int idProducto) {
		Factura factura = facturaDAO.findOne(idFactura);
		Producto producto = productoDAO.findOne(idProducto);
		FacturaDetalle facDetalle = new FacturaDetalle(idFacturaDetalle, cantidad, subtotal);
			facDetalle.setFactura(factura);
			facDetalle.setProducto(producto);
		facturaDetalleDAO.add(facDetalle);
	}

	@Override
	public int findMax() {
		return facturaDAO.findMax();
	}
}