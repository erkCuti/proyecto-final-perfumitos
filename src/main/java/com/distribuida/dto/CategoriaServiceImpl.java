package com.distribuida.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.CategoriaDAO;
import com.distribuida.entities.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> findAll() {
		return categoriaDAO.findAll();
	}

	@Override
	public List<Categoria> findAll(String busqueda) {
		return categoriaDAO.findAll(busqueda);
	}
	
	@Override
	public Categoria findOne(int id) {
		return categoriaDAO.findOne(id);
	}

	@Override
	public void add(Categoria categoria) {
		categoriaDAO.add(categoria);
	}

	@Override
	public void up(Categoria categoria) {
		categoriaDAO.up(categoria);
	}

	@Override
	public void del(int id) {
		categoriaDAO.del(id);
	}

	@Override
	public void add(int idCategoria, String categoriaConcentracion, String aroma, String descripcion,
			String durabilidad) {
		Categoria categoria = new Categoria(idCategoria, categoriaConcentracion, aroma, descripcion, durabilidad);
		categoriaDAO.add(categoria);
	}

	@Override
	public void up(int idCategoria, String categoriaConcentracion, String aroma, String descripcion,
			String durabilidad) {
		Categoria categoria = new Categoria(idCategoria, categoriaConcentracion, aroma, descripcion, durabilidad);
		categoriaDAO.up(categoria);
	}

	@Override
	public void imprimir(List<Categoria> categorias) {
		categorias.forEach(item ->{
			System.out.println(item);
		});
	}

}