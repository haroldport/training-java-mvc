package com.arquitecturajava.ejemplo002.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.ejemplo002.negocio.Curso;
import com.arquitecturajava.ejemplo002.servicios.ServicioCurso;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicioCurso sc = new ServicioCurso();
		List<Curso> lista = sc.buscarTodos();
		RequestDispatcher despachador = request.getRequestDispatcher("listaCursos.jsp");
		request.setAttribute("listaCursos", lista);
		despachador.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
