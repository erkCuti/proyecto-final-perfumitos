package com.distribuida.entities;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "factura_detalle")
public class FacturaDetalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura_detalle")
	private int idFacturaDetalle;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "subtotal")
	private double subtotal;
	
	
	@Autowired
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "id_factura")
	private Factura factura;
	
	@Autowired
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	
	public FacturaDetalle() {}

	public FacturaDetalle(int idFacturaDetalle, int cantidad, double subtotal) {
		this.idFacturaDetalle = idFacturaDetalle;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public int getIdFacturaDetalle() {
		return idFacturaDetalle;
	}

	public void setIdFacturaDetalle(int idFacturaDetalle) {
		this.idFacturaDetalle = idFacturaDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [idFacturaDetalle=" + idFacturaDetalle + ", cantidad=" + cantidad + ", subtotal="
				+ subtotal + ", factura=" + factura + ", producto=" + producto + "]";
	}
}