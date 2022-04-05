package com.edutecno.servlets;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.edutecno.dao.HoroscopoDaoImp;
import com.edutecno.dao.UsuariosDaoImp;
import com.edutecno.modelo.Horoscopo;
import com.edutecno.modelo.Usuarios;
import com.edutecno.procesaconexion.AdministradorConexion;

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuariosDaoImp userDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		this.userDao = new UsuariosDaoImp();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				try {
					insertUser(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;
			case "/deleteUser":
				try {
					deleteUser(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;
			case "/edit":
				System.out.println("entro");
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Usuarios> listUser = userDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Usuarios existingUser = userDao.selectUsuario(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException {

		Usuarios usuario = new Usuarios();
		String nombre = request.getParameter("nombre");
		String username = request.getParameter("username");
		String email = request.getParameter("email");

		String fecha_nacimiento = request.getParameter("fecha_nacimiento");
		String password = request.getParameter("password");

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaAux = formato.parse(fecha_nacimiento);
		System.out.println(fechaAux.getClass().getSimpleName());
		System.out.println("Fecha de Nacimiento del usuario : " + fechaAux);

		List<Horoscopo> listaHoroscopo = (new HoroscopoDaoImp()).obtenerHoroscopo();
		Horoscopo horoscopo = new Horoscopo();

		Date inicio;
		Date fin;

		for (Horoscopo temp : listaHoroscopo) {
			boolean resultado = fechaAux.after(temp.getFecha_Inicio());
			boolean resultado2 = fechaAux.before(temp.getFecha_Fin());
			inicio = formato.parse(formato.format(temp.getFecha_Inicio()));
			fin = formato.parse(formato.format(temp.getFecha_Fin()));

			if (fechaAux.after(inicio) && fechaAux.before(fin)) {
				System.out.println("if" + temp);
				horoscopo = temp;

			} else if (fechaAux.equals(inicio) || fechaAux.equals(fin)) {
				System.out.println("else" + temp);
				horoscopo = temp;

			}
		}

		usuario.setId(0);
		usuario.setNombre(nombre);
		usuario.setUsername(username);
		usuario.setEmail(email);
		usuario.setFecha_nacimiento(fechaAux);
		usuario.setPassword(password);
		String animal = horoscopo.getAnimal();
		usuario.setAnimal(animal);

		userDao.insertUsuario(usuario);

		response.sendRedirect("list");
	}

	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException {
		boolean rowActualizar = false;
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String fecha_nacimiento = request.getParameter("fecha_nacimiento");
		String password = request.getParameter("password");

		List<Horoscopo> listaHoroscopo = (new HoroscopoDaoImp()).obtenerHoroscopo();

		Horoscopo horoscopo = new Horoscopo();
		Date inicio;
		Date fin;

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaAux = formato.parse(fecha_nacimiento);
		for (Horoscopo temp : listaHoroscopo) {
			boolean resultado = fechaAux.after(temp.getFecha_Inicio());
			boolean resultado2 = fechaAux.before(temp.getFecha_Fin());

			inicio = formato.parse(formato.format(temp.getFecha_Inicio()));
			fin = formato.parse(formato.format(temp.getFecha_Fin()));

			if (fechaAux.after(inicio) && fechaAux.before(fin)) {
				System.out.println("if" + temp);
				horoscopo = temp;

			} else if (fechaAux.equals(inicio) || fechaAux.equals(fin)) {
				System.out.println("else" + temp);
				horoscopo = temp;

			}
		}

		String animal = horoscopo.getAnimal();

		Usuarios usuario = new Usuarios(id, nombre, username, email, fechaAux, password,animal);
		userDao.editarUsuario(usuario);
		response.sendRedirect("list");
		
		
	}
	

	/*private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Usuarios usuario = new Usuarios(request.getParameter("nombre"),
				request.getParameter("username"), request.getParameter("email"),
				request.getParameter("fecha_nacimiento"), request.getParameter("password"));
		userDao.editarUsuario(usuario);
		response.sendRedirect("list");
	}*/

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Usuarios usuarios = userDao.selectUsuario(Integer.parseInt(request.getParameter("id")));
		userDao.deleteUser(usuarios);
		response.sendRedirect("list");

	}

}
