package com.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	List<Horoscopo> listaHoroscopo = (new HoroscopoDaoImp()).obtenerHoroscopo();
	Horoscopo horoscopo = new Horoscopo();

	// METODO PARA OBTENER USUARIOS
	public List<Usuarios> obtenerUsuarios() {
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
				//Usuarios usu = new Usuarios(rs.getString("NOMBRE"), rs.getString("USERNAME"), rs.getString("EMAIL"));

			//	usuarios.add(usu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;

	}

	public void guardar(Usuarios u) throws SQLException {
		// Query que insertara el valor
		String sql = "INSERT INTO USUARIOS (nombre, username,email, fecha_nacimiento, password,animal)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getUsername());
			pstm.setString(3, u.getEmail());
			pstm.setDate(4, new java.sql.Date(u.getFecha_nacimiento().getTime()));
			pstm.setString(5, u.getPassword());
			String animal = u.getAnimal();
			pstm.setString(6, u.getAnimal());
			pstm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			// throw new RuntimeException("Ha ocurrido un error inesperado al guardar el
			// usuario"+ex);

		}

	}

	@Override
	public void obtenerAnimal(Usuarios u) {
		// TODO Auto-generated method stub

	}

	Connection con;
	AdministradorConexion cn = new AdministradorConexion();

	@Override
	public int validar(String nombre, String password) {

		int r = 0;
		String sql = "Select * from usuarios where nombre=? and password=?";
		try {
			con = cn.generaConexion();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombre);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				r = 1;

			}
			if (r == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}

	}

	public Usuarios usuario(String nombre, String password) {

		Usuarios user = null;
		String sql = "Select * from usuarios where nombre=? and password=?";
		try {

			con = cn.generaConexion();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombre);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				user = new Usuarios();
				user.setNombre(rs.getString("nombre"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setAnimal(rs.getString("animal"));

			}
			System.out.println(user.getAnimal());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	private static final String INSERT_USERS_SQL = "INSERT INTO USUARIOS (nombre, username,email, fecha_nacimiento, password,animal)"
			+ "VALUES(?,?,?,?,?,?)";
	private static final String SELECT_USER_BY_ID = "select id,nombre,username,  email, fecha_nacimiento, password, animal from usuarios where id=?";
	private static final String SELECT_ALL_USERS = "select id,nombre,username, email, animal from usuarios";
	private static final String DELETE_USERS_SQL = "delete form usuarios where id=?;";
	private static final String UPDATE_USERS_SQL = "update usuarios set nombre =?, username =? , email=?, fecha_nacimiento=?,  password =? where id =?;";

	// crear o insertar usuario
	public void insertUsuario(Usuarios u) throws SQLException {
		// Query que insertara el valor
		String sql = "INSERT INTO USUARIOS (nombre, username,email, fecha_nacimiento, password,animal)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getUsername());
			pstm.setString(3, u.getEmail());
			pstm.setDate(4, new java.sql.Date(u.getFecha_nacimiento().getTime()));
			pstm.setString(5, u.getPassword());
			String animal = u.getAnimal();
			pstm.setString(6, u.getAnimal());
			pstm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			// throw new RuntimeException("Ha ocurrido un error inesperado al guardar el
			// usuario"+ex);

		}

	}
	
	//Editar Usuario
	public boolean editarUsuario(Usuarios u) throws SQLException {
		
		boolean rowUpdated=false ;
		// Query que insertara el valor
		String sql =UPDATE_USERS_SQL;
		
		AdministradorConexion cn = new AdministradorConexion();
		Connection con = cn.generaConexion();
				PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(2, u.getNombre());
			pstm.setString(3, u.getUsername());
			pstm.setString(4, u.getEmail());
			pstm.setDate(4, new java.sql.Date(u.getFecha_nacimiento().getTime()));
			pstm.setString(5, u.getPassword());
			
			 rowUpdated = pstm.executeUpdate()>0;
			
		
		return rowUpdated;

	}
	
	
	//select user by id
	public Usuarios selectUsuario(int id) throws SQLException {
		Usuarios usuario = null;
		String sql =SELECT_USER_BY_ID;
		//Estableciendo una conexion
		try(Connection con = cn.generaConexion();
				//Creando un statement using connection obejct
				PreparedStatement pstm = conn.prepareStatement(sql);){
			pstm.setInt(1, id);
			System.out.println(pstm);
			//Ejecutar la query or el update query
			ResultSet rs = pstm.executeQuery();
			
			//Procesar el objeto ResultSet
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String username = rs.getString("username");
				String email = rs.getString("email");
				Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
				//String password = rs.getString("password");
				String animal = rs.getString("animal");
				
				usuario  = new Usuarios(id, nombre, username, email, fecha_nacimiento,animal);
			}}
			catch(SQLException e) {
				e.printStackTrace();
			}
			

		return usuario;
		
	}
	
	
	
	//Select Users
	public List<Usuarios> selectAllUsers(){
		String sql =SELECT_ALL_USERS;

		List <Usuarios> users = new ArrayList<>();
		//Step 1: Establecer una conexion
		
		try(Connection con = cn.generaConexion();
				//Creando un statement using connection obejct
				PreparedStatement pstm = conn.prepareStatement(sql);){
			System.out.println(pstm);
			ResultSet  rs = pstm.executeQuery();
			
			
			//Step 4;
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String animal = rs.getString("animal");
				users.add(new Usuarios(id,nombre,username, email, animal));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	//delete user
	/*public boolean deleteUser(Usuarios usuarios) throws SQLException{
		boolean rowDeleted;
		String sql = DELETE_USERS_SQL;
		try(Connection con = cn.generaConexion();
				//Creando un statement using connection obejct
				PreparedStatement pstm = conn.prepareStatement(sql);){
				pstm.setInt(1, usuarios.getId());
				rowDeleted = pstm.executeUpdate() >0;
		
	}
		return rowDeleted;
	
	}*/
	//eliminar
		public boolean deleteUser(Usuarios usuario) throws SQLException {
			boolean rowEliminar = false;
			String sql = "DELETE FROM usuarios WHERE ID=?";
			Connection con = cn.generaConexion();
			//Creando un statement using connection obejct
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, usuario.getId());
	 
			rowEliminar = pstm.executeUpdate() > 0;
			pstm.close();
			
	 
			return rowEliminar;
		}
	
	

}