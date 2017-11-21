package com.arquitecturajava.ejemplo002.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.ejemplo002.negocio.Curso;
import com.arquitecturajava.ejemplo002.servicios.ServicioCurso;

@WebServlet("/ServletControlador/*")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);		
	}
	
	protected void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		ServicioCurso sc = new ServicioCurso();
		RequestDispatcher despachador = null;
		
		if(accion.equals("ServletControlador")) {			
			despachador = request.getRequestDispatcher("/listaCursos.jsp");
			request.setAttribute("listaCursos", sc.buscarTodos());
		} else if(accion.equals("formularioInsertar")) {
			despachador = request.getRequestDispatcher("/formularioCurso.jsp");
		} else if(accion.equals("borrar")) {
			Curso c = new Curso(request.getParameter("nombre"), Integer.parseInt(request.getParameter("nivel")));
			sc.borrar(c);
			despachador = request.getRequestDispatcher("ServletControlador");
		} else {
			Curso c = new Curso(request.getParameter("nombre"), Integer.parseInt(request.getParameter("nivel")));
			sc.insertar(c);
			despachador = request.getRequestDispatcher("ServletControlador");
		}
		
		despachador.forward(request, response);
	}


}
