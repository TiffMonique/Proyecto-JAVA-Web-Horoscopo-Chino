package com.edutecno.servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.edutecno.modelo.Usuarios;
import com.edutecno.dao.UsuariosDaoImp;

/**
 * Servlet implementation class login
 */
//@WebServlet(name="login" , urlPatterns={"/login"})

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	Usuarios u=new Usuarios();
	UsuariosDaoImp  dao = new UsuariosDaoImp();
	int r =0;
	
	
    public login() {
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion; 
		response.setContentType("text/plain");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter writer = response.getWriter();
		 
		 sesion= request.getSession(true);
		
		 
		String nombre;
		String password;
		
		String accion=request.getParameter("accion");
		if(accion.equals("Ingresar")) {
			 nombre= request.getParameter("nombre");
			 password= request.getParameter("password");
			 //String animal = request.getParameter("animal");
			 System.out.println("Login: "+nombre+password);
			//u.setAnimal(animal);
			r= dao.validar(nombre, password);
			//System.out.println(u.getAnimal());
			if(r==1) {
				sesion.setAttribute("nombre", nombre);
				sesion.setAttribute("password", password);
				
				request.getRequestDispatcher("menu.jsp").forward(request, response);
				
			}else {
				request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
			}
			
		}else {
			request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
		}
	}

}
