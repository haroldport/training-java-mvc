package com.arquitecturajava.ejemplo002.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.ejemplo002.controladores.acciones.Accion;
import com.arquitecturajava.ejemplo002.controladores.acciones.CursoBorrarAccion;
import com.arquitecturajava.ejemplo002.controladores.acciones.CursoFiltrarNombre;
import com.arquitecturajava.ejemplo002.controladores.acciones.CursoInsertarAccion;
import com.arquitecturajava.ejemplo002.controladores.acciones.FormularioCursoAccion;
import com.arquitecturajava.ejemplo002.controladores.acciones.ListaCursoAccion;

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
		Accion miAccion = null;
		
		if(accion.equals("lista")) {			
			miAccion = new ListaCursoAccion();
			miAccion.ejecutar(request, response);
		} else if(accion.equals("formularioInsertar")) {
			miAccion = new FormularioCursoAccion();
			miAccion.ejecutar(request, response);
		} else if(accion.equals("borrar")) {
			miAccion = new CursoBorrarAccion();
			miAccion.ejecutar(request, response);
		} else if(accion.equals("filtrar")) {
			miAccion = new CursoFiltrarNombre();
			miAccion.ejecutar(request, response);
		} else {
			miAccion = new CursoInsertarAccion();
			miAccion.ejecutar(request, response);
		}
		
	}


}
