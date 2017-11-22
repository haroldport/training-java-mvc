package com.arquitecturajava.ejemplo002.controladores.acciones;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioCursoAccion implements Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher despachador = request.getRequestDispatcher("/formularioCurso.jsp");
		despachador.forward(request, response);
	}

}
