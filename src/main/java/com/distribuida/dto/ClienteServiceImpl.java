package com.distribuida.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public List<Cliente> findAll() {
		return clienteDAO.findAll();
	}

	@Override
	public List<Cliente> findAll(String busqueda) {
		return clienteDAO.findAll(busqueda);
	}
	
	@Override
	public Cliente findOne(int id) {
		return clienteDAO.findOne(id);
	}

	@Override
	public void add(Cliente cliente) {
		clienteDAO.add(cliente);
	}

	@Override
	public void up(Cliente cliente) {
		clienteDAO.up(cliente);
	}

	@Override
	public void del(int id) {
		clienteDAO.del(id);
	}

	@Override
	public void add(int idCliente, String cedula, String nombre, String apellido, String direccion, String telefono, String correo) {
		Cliente cliente = new Cliente(idCliente, cedula, nombre, apellido, direccion, telefono, correo);
		clienteDAO.add(cliente);
	}

	@Override
	public void up(int idCliente, String cedula, String nombre, String apellido, String direccion, String telefono, String correo) {
		Cliente cliente = new Cliente(idCliente, cedula, nombre, apellido, direccion, telefono, correo);
		clienteDAO.up(cliente);
	}

	@Override
	public void imprimir(List<Cliente> clientes) {
		clientes.forEach(item ->{
			System.out.println(item);
		});
	}

}