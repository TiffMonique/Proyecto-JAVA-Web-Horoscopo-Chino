package com.edutecno.modelo;

import java.util.Date;

public class Horoscopo {
	private String animal;
	private Date fecha_Inicio;
	private Date fecha_Fin;
	
	
	public Horoscopo(String animal, Date fecha_Inicio, Date fecha_Fin) {
		super();
		this.animal = animal;
		this.fecha_Inicio = fecha_Inicio;
		this.fecha_Fin = fecha_Fin;
	}


	public Horoscopo() {
		super();
	}


	public String getAnimal() {
		return animal;
	}


	public void setAnimal(String animal) {
		this.animal = animal;
	}


	public Date getFecha_Inicio() {
		return fecha_Inicio;
	}


	public void setFecha_Inicio(Date fecha_Inicio) {
		this.fecha_Inicio = fecha_Inicio;
	}


	public Date getFecha_Fin() {
		return fecha_Fin;
	}


	public void setFecha_Fin(Date fecha_Fin) {
		this.fecha_Fin = fecha_Fin;
	}


	@Override
	public String toString() {
		return "Horóscopo [animal=" + animal + ", fecha_Inicio=" + fecha_Inicio + ", fecha_Fin=" + fecha_Fin + "]";
	}

}
