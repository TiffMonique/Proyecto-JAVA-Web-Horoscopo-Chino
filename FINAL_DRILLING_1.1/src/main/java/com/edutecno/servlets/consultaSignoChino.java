package com.edutecno.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.edutecno.dao.UsuariosDaoImp;
import com.edutecno.modelo.Usuarios;

/**
 * Servlet implementation class consultaSignoChino
 */
@WebServlet("/consultaSignoChino")
public class consultaSignoChino extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultaSignoChino() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuariosDaoImp  dao = new UsuariosDaoImp();
		
		HttpSession sesion= (HttpSession) request.getSession();
		 
		String nombre= (String) sesion.getAttribute("nombre"); 
		String password= (String) sesion.getAttribute("password"); 
		System.out.println(nombre+password);
		
		Usuarios user = new Usuarios();
		user = dao.usuario(nombre, password);
		request.setAttribute("animal", user.getAnimal());
		
		RequestDispatcher dis = getServletContext().getRequestDispatcher("/consultaSignoChino.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
