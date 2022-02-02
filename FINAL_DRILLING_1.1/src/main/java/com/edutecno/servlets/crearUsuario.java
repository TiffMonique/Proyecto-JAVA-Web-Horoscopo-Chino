package com.edutecno.servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.edutecno.dao.HoróscopoDaoImp;
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
		
		
		/*response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<body>");
	    out.println("<h1>Hola Mundo</h1>");
	    out.println("</body>");
	    out.println("</html>");*/
		
		log(fecha_nacimiento);
		System.out.println(fecha_nacimiento);
	    
		SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
		Date fechaAux=formato.parse(fecha_nacimiento);
		
		List<Horoscopo> listaHoroscopo = (new HoróscopoDaoImp()).obtenerHoroscopo();
		Horoscopo horoscopo = new Horoscopo();
		
		for (Horoscopo temp : listaHoroscopo) {
			if (fechaAux.after(temp.getFecha_Inicio())
					&& fechaAux.before(temp.getFecha_Fin())) {
				horoscopo = temp;
			} else if (fechaAux.equals(temp.getFecha_Inicio())
					|| fechaAux.equals(temp.getFecha_Fin())) {
				horoscopo = temp;
			}
		}
		
		usuario.setId(0);
		usuario.setNombre(nombre);
		usuario.setUsername(username);
		usuario.setEmail(email);
		
		
		usuario.setFecha_nacimiento(fechaAux);
		usuario.setPassword(password);
		usuario.setAnimal(horoscopo.getAnimal());
		//int id, String nombre, String username, String email, Date fecha_nacimiento, String password,
		//String animal
		
		
		UsuariosDaoImp daoUsuario = new UsuariosDaoImp();
		try {
			daoUsuario.guardar(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
