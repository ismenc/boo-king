package com.booking.persistencia;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Define la relacion prestamo-libro N-M. Es una pila de una cantidad de un libro.
 * Alguien puede prestar varias pilas en un prestamo.
 * @author Ismael Nunez
 *
 */
@Entity
@Table(name="stack")
public class Stack implements Serializable {
	private static final long serialVersionUID = 1L;

	/* ------------------- Atributos ------------------- */
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idStack;
	
	@Column
	private int cantidad;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="idPrestamo")
	private Prestamo prestamo;
	
	@ManyToOne
	@JoinColumn(name="idLibro")
	private Libro libro;
	
	/* ------------------- Constructor ------------------- */
	
	public Stack() { }

	public Stack(Libro libro, int cantidad, Prestamo prestamo) {
		this.cantidad = cantidad;
		this.prestamo = prestamo;
		this.libro = libro;
	}

	/* ----------------- Getter & Setter ----------------- */

	public int getIdStack() {
		return idStack;
	}

	public void setIdStack(int idStack) {
		this.idStack = idStack;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	/* -------------------- Métodos -------------------- */

	@Override
	public String toString() {
		return idStack + " - " + cantidad+ "x" + libro.getTitulo();
	}
}