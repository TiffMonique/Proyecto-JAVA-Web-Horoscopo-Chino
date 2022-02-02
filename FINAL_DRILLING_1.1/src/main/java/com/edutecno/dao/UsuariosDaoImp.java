package com.edutecno.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import com.edutecno.modelo.Horoscopo;
import com.edutecno.modelo.Usuarios;
import com.edutecno.procesaconexion.AdministradorConexion;

public class UsuariosDaoImp extends AdministradorConexion implements UsuariosDao {

	public UsuariosDaoImp() {
		Connection conn = generaPoolConexion();
	}

	List<Horoscopo> listaHoroscopo = (new HoróscopoDaoImp()).obtenerHoroscopo();
	Horoscopo horoscopo = new Horoscopo();

/*	public void obtenerAnimal(Usuarios usuario) {
		// TODO Auto-generated method stub
		for (Horoscopo temp : listaHoroscopo) {
			if (usuario.getFecha_nacimiento().after(temp.getFecha_Inicio())
					&& usuario.getFecha_nacimiento().before(temp.getFecha_Fin())) {
				horoscopo = temp;
			} else if (usuario.getFecha_nacimiento().equals(temp.getFecha_Inicio())
					|| usuario.getFecha_nacimiento().equals(temp.getFecha_Fin())) {
				horoscopo = temp;
			}
		}
		usuario.setAnimal(horoscopo.getAnimal());
	}
*/
	
	//METODO PARA OBTENER USUARIOS
	public List<Usuarios> obtenerUsuarios()  {
		String consultaSql = "SELECT * FROM usuarios";
		List<Usuarios> usuarios = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(consultaSql);
			rs = pstm.executeQuery();
			while (rs.next()) {

				// String nombre, String username, String email, Date fecha_nacimiento, String
				// password, String animal
				Usuarios u = new Usuarios(rs.getInt("id"), rs.getString("nombre"), rs.getString("username"),
						rs.getString("email"), rs.getDate("fecha_nacimiento"), rs.getString("password"),
						rs.getString("animal"));
				usuarios.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	// Metodo para la busqueda de un Usuario
	@Override
	public List<Usuarios> obtieneUsuario(String nomUsuario) {
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		String query = "SELECT * FROM USUARIOS" + "WHERE ";

		if (nomUsuario.isEmpty() && nomUsuario.isEmpty()) {
			query = "SELECT * FROM USUARIOS";
		} else {
			query += "USER.NOMBRE LIKE UPPER('%" + nomUsuario + "%')";
		}

		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Usuarios usu = new Usuarios(rs.getString("NOMBRE"), rs.getString("USERNAME"), rs.getString("EMAIL"));

				usuarios.add(usu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;

	}

	
	
	public void guardar(Usuarios u) throws SQLException{
		
		//Query que insertara el valor
		String sql = "INSERT INTO USUARIOS (nombre, username,email, fecha_nacimiento, password,animal)"
						+"VALUES(?,?,?,?,?,?)";
	 try {
		 pstm = conn.prepareStatement(sql);
		 	pstm.setString(1,u.getNombre());
			pstm.setString(2,u.getUsername());
			pstm.setString(3,u.getEmail());
			
			//java.sql.Date fecha = new java.sql.Date();
			
			//Date date = new Date(0);
			//pstm.setDate(3, ((java.sql.Date) date).valueOf(u.getFecha_nacimiento()));
			
			//pstm.setDate(5, new java.sql.Date(cal.u.getFecha_nacimiento()), cal);
			//pstm.setDate(5, new java.sql.Date(u.getFecha_nacimiento());
			
			
			//Date fecha_nacimiento =((ResultSet) pstm).getDate("Fecha_nacimiento");
			//pstm.setDate(5,(java.sql.Date) fecha_nacimiento);
			pstm.setDate(4, new java.sql.Date(u.getFecha_nacimiento().getTime()));
			pstm.setString(5,u.getPassword());
			
			//pstm.setDate(6, new Date(u.getFecha_nacimiento());
			
			//pstm.setDate(6, new java.sql.Date(u.getFecha_nacimiento().getTime()));
			//java.sql.Date fecha = new java.sql.Date(u.getTime());
			
			//pstm.setDate(5, new java.sql.Date(u.getFecha_nacimiento()));
			
			
			for (Horoscopo temp : listaHoroscopo) {
				if (u.getFecha_nacimiento().after(temp.getFecha_Inicio())
						&& u.getFecha_nacimiento().before(temp.getFecha_Fin())) {
					horoscopo = temp;
				} else if (u.getFecha_nacimiento().equals(temp.getFecha_Inicio())
						|| u.getFecha_nacimiento().equals(temp.getFecha_Fin())) {
					horoscopo = temp;
				}
			}
			u.setAnimal(horoscopo.getAnimal());
			
			 pstm.setString(6,u.getAnimal() );
			 
			pstm.executeUpdate();
	 }catch(Exception ex) {
		 ex.printStackTrace();
		 throw new RuntimeException("Ha ocurrido un error inesperado al guardar el usuario"+ex);
		 
	 }
			
		
		
	}

	@Override
	public void obtenerAnimal(Usuarios u) {
		// TODO Auto-generated method stub
		
	}
	
}
