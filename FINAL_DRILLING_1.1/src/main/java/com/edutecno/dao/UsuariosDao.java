package com.edutecno.dao;

import java.util.List;

import com.edutecno.modelo.Usuarios;

public interface UsuariosDao {
	
	public List<Usuarios> obtenerUsuarios() ;
	public void obtenerAnimal(Usuarios u);
	public List<Usuarios> obtieneUsuario(String nomUsuario) ;
	public int validar(String nombre, String password);


}
