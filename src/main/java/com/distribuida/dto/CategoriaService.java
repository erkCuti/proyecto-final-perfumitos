package com.distribuida.dto;

import java.util.List;

import com.distribuida.entities.Categoria;

public interface CategoriaService {
	
	public List<Categoria> findAll();
	
	public List<Categoria> findAll(String busqueda);
	
	public Categoria findOne(int id); 
	
	public void add(Categoria categoria);
	
	public void up(Categoria categoria);
	
	public void del(int id); 
	
	
	public void add(int idCategoria, String categoriaConcentracion, String aroma, String descripcion, String durabilidad);

	public void up(int idCategoria, String categoriaConcentracion, String aroma, String descripcion, String durabilidad);
	
	public void imprimir(List<Categoria> categorias);

}