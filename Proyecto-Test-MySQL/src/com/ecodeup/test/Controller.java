package com.ecodeup.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TestDAO testDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL);
		try {
			testDAO = new TestDAO(jdbcURL, jdbcUserName, jdbcPassword);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("opcion");
		switch (op) {
		case "1":
			Articulo articulo = new Articulo(0, "Televisor", "Televisor LG 25 Pulgadas", 560);
			if (testDAO.registar(articulo)) {
				System.out.println("Articulo Ingresado");
			} else {
				System.out.println("Articulo No Ingresado");
			}
			break;
			
		case "2":
			Articulo a1 = new Articulo(2, "Computadora", "Televisor LG 60 Pulgadas", 560);
			if (testDAO.actualizar(a1)) {
				System.out.println("Articulo Actualizado");
			} else {
				System.out.println("Articulo No Actualizado");
			}
			break;
		case "3":
			Articulo a2 = new Articulo(1, "Computadora", "Televisor LG 60 Pulgadas", 560);
			if (testDAO.eliminar(a2)) {
				System.out.println("Articulo Eliminado");
			} else {
				System.out.println("Articulo No Eliminado");
			}
			break;
		case "4":
			testDAO.ObtenerArticulo(2);
			break;
		case "5":
			testDAO.obtenerArticulos();
			break;
		default:
			break;
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
