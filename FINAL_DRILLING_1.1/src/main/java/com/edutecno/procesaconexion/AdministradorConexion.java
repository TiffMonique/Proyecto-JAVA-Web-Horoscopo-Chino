package com.edutecno.procesaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdministradorConexion {
	
	

	protected static Connection conn;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;

	// Genera una conexion a la DB
	protected Connection generaConexion() {
		String usr = "final_Drilling";
		String pwd = "123";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, usr, pwd);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	// Genera un pool de conexiones a la DB
	protected Connection generaPoolConexion() {
// Se modificó /Servers/Tomcat\v9.0 Server\at\localhost/context.xml y se creó Horoscopo/WebContent/WEB-INF/web.xml
		Context initContext;
		if (conn == null) {
			try {
				initContext = new InitialContext();
				DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/ConexionOracle");
				try {
					conn = ds.getConnection();
					System.out.println("CREACION DE CONEXION CON GetConnection");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

}
