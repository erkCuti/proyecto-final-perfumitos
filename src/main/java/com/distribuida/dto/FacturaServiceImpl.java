package com.distribuida.dto;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.entities.Cliente;
import com.distribuida.entities.Factura;

@Service
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaDAO facturaDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return facturaDAO.findAll();
	}

	@Override
	public Factura findOne(int id) {
		// TODO Auto-generated method stub
		return facturaDAO.findOne(id);
	}

	@Override
	public void add(Factura factura) {
		// TODO Auto-generated method stub
		facturaDAO.add(factura);

	}

	@Override
	public void up(Factura factura) {
		// TODO Auto-generated method stub
		facturaDAO.up(factura);

	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		facturaDAO.del(id);

	}

	@Override
	public void add(int idFactura, String numFactura, Date fecha, double totalNeto, double iva, double total,
			int idCliente) {
		// TODO Auto-generated method stub
		
		Cliente cliente = clienteDAO.findOne(idCliente);
		
		Factura factura = new Factura(idFactura, numFactura, fecha, totalNeto, iva, total);
		
		factura.setCliente(cliente);
		
		facturaDAO.add(factura);

	}

	@Override
	public void up(int idFactura, String numFactura, Date fecha, double totalNeto, double iva, double total,
			int idCliente) {
		// TODO Auto-generated method stub
		
		Cliente cliente = clienteDAO.findOne(idCliente);
		
		Factura factura = new Factura(idFactura, numFactura, fecha, totalNeto, iva, total);
		
		factura.setCliente(cliente);
		
		facturaDAO.up(factura);

	}

	@Override
	public void imprimir(List<Factura> factura) {
		// TODO Auto-generated method stub
		factura.forEach(item ->{
			System.out.println(item);
		});

	}

	@Override
	public List<Factura> findAll(String busqueda) {
		// TODO Auto-generated method stub
		return facturaDAO.findAll(busqueda);
	}

	

}
