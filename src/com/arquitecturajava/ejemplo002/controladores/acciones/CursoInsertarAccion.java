package com.arquitecturajava.ejemplo002.controladores.acciones;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.ejemplo002.negocio.Curso;
import com.arquitecturajava.ejemplo002.servicios.ServicioCurso;

public class CursoInsertarAccion implements Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServicioCurso sc = new ServicioCurso();
		Curso c = new Curso(request.getParameter("nombre"), Integer.parseInt(request.getParameter("nivel")));
		sc.insertar(c);
		RequestDispatcher despachador = request.getRequestDispatcher("lista");
		despachador.forward(request, response);
	}

}
