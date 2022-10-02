package com.alura.jdbc.modelo;

import java.sql.Date;

public class Huesped {

	private Integer id;
	private String nombre;
	private String apellido;
	private Date fNacto;
	private String nacionalidad;
	private String telefono;
	private Integer idReserva;
	
	public Huesped(Integer id, String nombre, String apellido, Date fNacto, String nacionalidad, String telefono, Integer idReserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fNacto = fNacto;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}
	
	public Huesped(String nombre, String apellido, Date fNacto, String nacionalidad, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fNacto = fNacto;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	
	public Huesped() {	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getfNacto() {
		return fNacto;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public Integer getIdReserva() {
		return this.idReserva;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setfNacto(Date fNacto) {
		this.fNacto = fNacto;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setReservaId(Integer idReserva) {
		this.idReserva = idReserva;
	}
	
}
