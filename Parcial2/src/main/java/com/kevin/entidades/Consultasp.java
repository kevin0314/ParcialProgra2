package com.kevin.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the consultasp database table.
 * 
 */
@Entity
@NamedQuery(name="Consultasp.findAll", query="SELECT c FROM Consultasp c")
public class Consultasp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String apellido;

	private String nombre;

	public Consultasp() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}