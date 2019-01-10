package com.ecodeup.model;

import java.sql.Date;

public class Producto {
	private int id;
	private String nombre;
	private double cantidad;
	private double precio;
	private Date fechaCrea;
	private Date fechaAct;
	
	public Producto(int id, String nombre, double cantidad, double precio, Date fechaCrea, Date fechaAct) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fechaCrea = fechaCrea;
		this.fechaAct = fechaAct;
	}
	
	public Producto() {
		super();
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getCantidad() {
		return cantidad;
	}


	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Date getFechaCrea() {
		return fechaCrea;
	}


	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}


	public Date getFechaAct() {
		return fechaAct;
	}


	public void setFechaAct(Date fechaAct) {
		this.fechaAct = fechaAct;
	}	
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", fechaCrea=" + fechaCrea + ", fechaAct=" + fechaAct + "]";
	}
	
}
