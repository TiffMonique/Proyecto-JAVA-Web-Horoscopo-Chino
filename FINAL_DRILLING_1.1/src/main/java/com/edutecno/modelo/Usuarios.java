package com.edutecno.modelo;

import java.util.Date;

public class Usuarios {
	
	private int id;
	private String nombre;
	private String username;
	private String email;
	private Date fecha_nacimiento;
	private String password;
	private String animal;
	




	
	
	



	//Constructor cont todo

	public Usuarios(int id, String nombre, String username, String email, Date fecha_nacimiento, String password,
			String animal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.password = password;
		this.animal = animal;
	}



	

	
	//id,nombre,username, email, animal

	public Usuarios(int id, String nombre, String username, String email,  String animal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.animal = animal;
	}


	//select user
	



	public Usuarios() {
		super();
	}






	public Usuarios(int id, String nombre, String username, String email, Date fecha_nacimiento, String animal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.animal = animal;
	}






	public Usuarios(String nombre, String username, String email, Date fecha_nacimiento, String password) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.password = password;
	}






	public Usuarios(String parameter, String parameter2, String parameter3, String parameter4, String parameter5) {
		// TODO Auto-generated constructor stub
	}






	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAnimal() {
		return animal;
	}

	


	

	public void setAnimal(String animal) {
		this.animal = animal;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	



	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", username=" + username + ", email=" + email
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", password=" + password + ", animal=" + animal + "]";
	}



}
