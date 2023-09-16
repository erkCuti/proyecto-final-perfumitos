package com.distribuida.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private int idProducto;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "marca")
	private String marca;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "fabricacion")
	private String fabricacion;
	@Column(name = "fecha_fabricacion")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date fechaFabricacion;
	@Column(name = "fecha_expiracion")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date fechaExpiracion;
	@Column(name = "colonia_for")
	private String coloniaFor;
	@Column(name = "tamanio")
	private String tamanio;
	@Column(name = "logo")
	private String logo;
	@Column(name = "precio")
	private double precio;
	@Column (name = "stock")
	private int stock;

	@Autowired
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "id_categoria")
	private Categoria categoria = null;
	
	public Producto () {}

	public Producto(int idProducto, String nombre, String marca, String descripcion, String fabricacion,
			Date fechaFabricacion, Date fechaExpiracion, String coloniaFor, String tamanio, String logo, double precio, int stock) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.fabricacion = fabricacion;
		this.fechaFabricacion = fechaFabricacion;
		this.fechaExpiracion = fechaExpiracion;
		this.coloniaFor = coloniaFor;
		this.tamanio = tamanio;
		this.logo = logo;
		this.precio = precio;
		this.stock = stock;
	}

	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFabricacion() {
		return fabricacion;
	}

	public void setFabricacion(String fabricacion) {
		this.fabricacion = fabricacion;
	}

	public Date getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(Date fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getColoniaFor() {
		return coloniaFor;
	}

	public void setColoniaFor(String coloniaFor) {
		this.coloniaFor = coloniaFor;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", marca=" + marca + ", descripcion="
				+ descripcion + ", fabricacion=" + fabricacion + ", fechaFabricacion=" + fechaFabricacion
				+ ", fechaExpiracion=" + fechaExpiracion + ", coloniaFor=" + coloniaFor + ", tamanio=" + tamanio
				+ ", logo=" + logo + ", precio=" + precio + ", stock=" + stock + ", categoria=" + categoria + "]";
	}
}