package com.ecodeup.proyecto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Ingresamos al metodo GET de MyServlet");
		System.out.println("Parametro enviado via GET: "+request.getParameter("var1"));
		System.out.println("Parametro enviado via GET: "+request.getParameter("var2"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("Ingresamos al metodo POST de MyServlet");
		System.out.println("Parametro enviado via POST:" + request.getParameter("txtNombre"));
		
		//Opcion request
		request.setAttribute("name", request.getParameter("txtNombre"));
		
		//Opcion de Session
		request.getSession().setAttribute("nameSession",request.getParameter("txtNombre"));
		
		//Opcion de Contexto
		getServletContext().setAttribute("nameContext", request.getParameter("txtNombre"));
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/Presentacion.jsp");
		rd.forward(request, response);
	}

}
