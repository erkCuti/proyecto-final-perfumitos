package com.distribuida.dto;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.CategoriaDAO;
import com.distribuida.dao.ProductoDAO;
import com.distribuida.entities.Categoria;
import com.distribuida.entities.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoDAO productoDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;

	@Override
	public List<Producto> findAll() {
		return productoDAO.findAll();
	}
	
	@Override
	public List<Producto> findAll(String busqueda) {
		return productoDAO.findAll(busqueda);
	}

	@Override
	public Producto findOne(int id) {
		return productoDAO.findOne(id);
	}

	@Override
	public void add(Producto producto) {
		productoDAO.add(producto);
	}

	@Override
	public void up(Producto prodcuto) {
		productoDAO.up(prodcuto);
	}

	@Override
	public void del(int id) {
		productoDAO.del(id);
	}

	@Override
	public void add(int idProducto, String nombre, String marca, String descripcion, String fabricacion, Date fechaFabricacion,
			Date fechaExpiracion, String coloniaFor, String tamanio, String logo, double precio, int stock, int idCategoria) {
		
		Categoria categoria = categoriaDAO.findOne(idCategoria);
		Producto producto = new Producto(idProducto, nombre, marca, descripcion, fabricacion, fechaFabricacion, 
										fechaExpiracion, coloniaFor, tamanio, logo, precio, stock); 

		producto.setCategoria(categoria);
		
		productoDAO.add(producto);
	}

	@Override
	public void up(int idProducto, String nombre, String marca, String descripcion, String fabricacion, Date fechaFabricacion,
			Date fechaExpiracion, String coloniaFor, String tamanio, String logo, double precio, int stock, int idCategoria) {
		
		Categoria categoria = categoriaDAO.findOne(idCategoria);
		Producto producto = new Producto(idProducto, nombre, marca, descripcion, fabricacion, fechaFabricacion, 
				fechaExpiracion, coloniaFor, tamanio, logo, precio, stock); 
		
		producto.setCategoria(categoria);
		
		productoDAO.up(producto);
	}

	@Override
	public void imprimir(List<Producto> productos) {
		productos.forEach(item ->{
			System.out.println(item);
		});
	}
}