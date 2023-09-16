package com.distribuida.dto;
import java.util.Date;
import java.util.List;

import com.distribuida.entities.Producto;

public interface ProductoService {
	
	public List<Producto> findAll();
	
	public List<Producto> findAll(String busqueda);
	
	public Producto findOne(int id);
	
	public void add (Producto producto);
	
	public void up (Producto prodcuto);
	
	public void del (int id);
	
	public void add(int idProducto, String nombre, String marca, String descripcion, String fabricacion,
			Date fechaFabricacion, Date fechaExpiracion, String coloniaFor, String tamanio, String logo, 
			double precio, int stock, int idCategoria);
	
	public void up(int idProducto, String nombre, String marca, String descripcion, String fabricacion,
			Date fechaFabricacion, Date fechaExpiracion, String coloniaFor, String tamanio, String logo, 
			double precio, int stock, int idCategoria);
	
	public void imprimir(List<Producto> productos);
	
}