package com.distribuida.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private int idCategoria;
	@Column(name = "categoria_concentacion")
	private String categoriaConcentacion;
	@Column(name = "aroma")
	private String aroma;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "durabilidad")
	private String durabilidad;
	
	
	public Categoria () {}
	
	public Categoria(int idCategoria, String categoriaConcentacion, String aroma, String descripcion, String durabilidad) {
		this.idCategoria = idCategoria;
		this.categoriaConcentacion = categoriaConcentacion;
		this.aroma = aroma;
		this.descripcion = descripcion;
		this.durabilidad = durabilidad;
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoriaConcentacion() {
		return categoriaConcentacion;
	}

	public void setCategoriaConcentacion(String categoriaConcentacion) {
		this.categoriaConcentacion = categoriaConcentacion;
	}

	public String getAroma() {
		return aroma;
	}

	public void setAroma(String aroma) {
		this.aroma = aroma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDurabilidad() {
		return durabilidad;
	}

	public void setDurabilidad(String durabilidad) {
		this.durabilidad = durabilidad;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", categoriaConcentacion=" + categoriaConcentacion + ", aroma="
				+ aroma + ", descripcion=" + descripcion + ", durabilidad=" + durabilidad + "]";
	}
}