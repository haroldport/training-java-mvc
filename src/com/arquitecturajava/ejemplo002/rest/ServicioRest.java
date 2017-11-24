package com.arquitecturajava.ejemplo002.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.arquitecturajava.ejemplo002.negocio.Curso;
import com.arquitecturajava.ejemplo002.servicios.ServicioCurso;

@Path(value = "/cursos")
public class ServicioRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> listaCursos() {
		ServicioCurso sc = new ServicioCurso();
		return sc.buscarTodos();
	}

	@GET
	@Path("/filtro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> filtroPorNombre() {
		ServicioCurso sc = new ServicioCurso();
		return sc.buscarTodos();
	}
	
	@GET
	@Path("/filtro/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> filtroPorNombre(@PathParam("nombre") String nombre) {
		ServicioCurso sc = new ServicioCurso();
		return sc.buscarPorNombre(nombre);
	}

}
