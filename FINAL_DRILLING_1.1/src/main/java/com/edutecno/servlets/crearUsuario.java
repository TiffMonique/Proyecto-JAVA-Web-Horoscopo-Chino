package com.edutecno.servlets;

import jakarta.servlet.ServletException;



import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.edutecno.dao.HoroscopoDaoImp;
import com.edutecno.dao.UsuariosDaoImp;
import com.edutecno.modelo.Horoscopo;
import com.edutecno.modelo.Usuarios;

/**
 * Servlet implementation class crearUsuario
 */
@WebServlet(name="crearUsuario" , urlPatterns={"/crearUsuario"})
public class crearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public crearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion =request.getParameter("operacion");
		
		if(operacion !=null) {
			if(operacion.equals("crear")) {
				try {
					crearUsuario(request, response);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void crearUsuario(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		//Capturar los campos que el usuario escribio en el formulario
		
		Usuarios usuario = new Usuarios();
		String nombre= request.getParameter("nombre");
		String username= request.getParameter("username");
		String email = request.getParameter("email");
		
		String fecha_nacimiento = request.getParameter("fecha_nacimiento");
		
		String password = request.getParameter("password");
	
		
		
		//fecha_nacimiento= DateFormat.getDateInstance().format(fecha_nacimiento);
		
		
		SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
	      Date fechaAux=formato.parse(fecha_nacimiento);
	      
	      
	    //Date fechaAux=formato.parse.format(fecha_nacimiento);
	    System.out.println(fechaAux.getClass().getSimpleName());
	    System.out.println("Fecha de Nacimiento del usuario : "+fechaAux);
	    
	    
	    
		
		List<Horoscopo> listaHoroscopo = (new HoroscopoDaoImp()).obtenerHoroscopo();
		
		Horoscopo horoscopo = new Horoscopo();
		
		/*for (Horoscopo temp : listaHoroscopo) {
			System.out.println(temp);
			
		}*/
		
		
	Date inicio;
	
	
	Date fin;
	
		for (Horoscopo temp : listaHoroscopo) {
			boolean resultado = fechaAux.after(temp.getFecha_Inicio());
			boolean resultado2 = fechaAux.before(temp.getFecha_Fin());
			//System.out.println("resultado "+resultado);
			//System.out.println("resultado2"+resultado2);
		
			
			inicio =formato.parse(formato.format(temp.getFecha_Inicio()));
			fin=formato.parse(formato.format(temp.getFecha_Fin()));
			
			/*
			System.out.println("Fecha inicio Horoscopo "+formato.parse(formato.format(temp.getFecha_Inicio())));
			
			System.out.println("Fecha fin Horoscopo "+formato.parse(formato.format(temp.getFecha_Fin())));
			System.out.println("Fecha Nacimiento "+fechaAux);*/
			
			if (fechaAux.after(inicio)
					&& fechaAux.before(fin)) {
				System.out.println("if"+temp);
				horoscopo = temp;
				
			} else if (fechaAux.equals(inicio)
					|| fechaAux.equals(fin)) {
				System.out.println("else"+temp);
				horoscopo = temp;
				
			}
		}
		
		usuario.setId(0);
		usuario.setNombre(nombre);
		usuario.setUsername(username);
		usuario.setEmail(email);
		usuario.setFecha_nacimiento(fechaAux);
		usuario.setPassword(password);
		String animal= horoscopo.getAnimal();
		usuario.setAnimal(animal);
		
		//System.out.println("Este es el animal "+animal);
		
		UsuariosDaoImp daoUsuario = new UsuariosDaoImp();
		try {
			daoUsuario.guardar(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}