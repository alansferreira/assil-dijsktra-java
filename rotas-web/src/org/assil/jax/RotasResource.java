package org.assil.jax;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import assil.algorithms.dijkstra.Edge;
import assil.algorithms.dijkstra.EdgeMap;
import assil.algorithms.dijkstra.Engine;
import assil.algorithms.dijkstra.Graph;
import assil.algorithms.dijkstra.Vertex;
import assil.algorithms.dijkstra.VertexMap;

@Path("/rotas")
public class RotasResource {

	static HashMap<String, Graph<Vertex, Edge<Vertex>>> mapas = new HashMap<String, Graph<Vertex,Edge<Vertex>>>();
	
	static{
		VertexMap<Vertex> vertexes;
		EdgeMap<Vertex, Edge<Vertex>> edges;
		Graph<Vertex, Edge<Vertex>> mapa; 
		
		vertexes = new VertexMap<Vertex>();
		edges = new EdgeMap<Vertex, Edge<Vertex>>();

		vertexes.put(new Vertex("A"));
		vertexes.put(new Vertex("B"));
		vertexes.put(new Vertex("C"));
		vertexes.put(new Vertex("D"));
		vertexes.put(new Vertex("E"));

		edges.put(new Edge<Vertex>("Edge_1", vertexes.get("A"), vertexes.get("B"), 10));
		edges.put(new Edge<Vertex>("Edge_1", vertexes.get("B"), vertexes.get("D"), 15));
		edges.put(new Edge<Vertex>("Edge_2", vertexes.get("A"), vertexes.get("C"), 10));
		edges.put(new Edge<Vertex>("Edge_3", vertexes.get("C"), vertexes.get("D"), 30));
		edges.put(new Edge<Vertex>("Edge_4", vertexes.get("B"), vertexes.get("E"), 50));
		edges.put(new Edge<Vertex>("Edge_5", vertexes.get("D"), vertexes.get("E"), 130));

		mapa = new Graph<Vertex, Edge<Vertex>>(vertexes, edges);
		mapas.put("mapa1", mapa);


		vertexes = new VertexMap<Vertex>();
		edges = new EdgeMap<Vertex, Edge<Vertex>>();

		vertexes.put(new Vertex("A"));
		vertexes.put(new Vertex("B"));
		vertexes.put(new Vertex("C"));
		vertexes.put(new Vertex("D"));
		vertexes.put(new Vertex("E"));

		edges.put(new Edge<Vertex>("Edge_1", vertexes.get("A"), vertexes.get("B"), 10));
		edges.put(new Edge<Vertex>("Edge_1", vertexes.get("B"), vertexes.get("D"), 15));
		edges.put(new Edge<Vertex>("Edge_2", vertexes.get("A"), vertexes.get("C"), 20));
		edges.put(new Edge<Vertex>("Edge_3", vertexes.get("C"), vertexes.get("D"), 30));
		edges.put(new Edge<Vertex>("Edge_4", vertexes.get("B"), vertexes.get("E"), 50));
		edges.put(new Edge<Vertex>("Edge_5", vertexes.get("D"), vertexes.get("E"), 30));

		mapa = new Graph<Vertex, Edge<Vertex>>(vertexes, edges);
		mapas.put("mapa2", mapa);
	}
	
	//http://localhost:8080/rotas-web/rest/rotas/rota/mapa2/A/E/10/2.5
	@GET
	@Path("/rota/{mapa}/{origem}/{destino}/{autonomia}/{custolitro}")
	@Produces(MediaType.APPLICATION_JSON)
	public Rota getRota(@PathParam("mapa") String mapa,
			@PathParam("origem") String origem,
			@PathParam("destino") String destino,
			@PathParam("autonomia") double autonomia,
			@PathParam("custolitro") double custolitro) {
		
		
		Graph<Vertex, Edge<Vertex>> graph = mapas.get(mapa.toLowerCase().trim());
		Vertex vOrigem = graph.getVertexes().get(origem.trim().toUpperCase());
		Vertex vDestino = graph.getVertexes().get(destino.trim().toUpperCase());
		
		Engine<Vertex, Edge<Vertex>> engine = new Engine<Vertex, Edge<Vertex>>(graph);
		
		
		engine.execute(vOrigem);
	    
	    List<Edge<Vertex>> path = engine.getPathEdges(vDestino);
	    
	    return new Rota(path, autonomia, custolitro);
	    
	    
	}
}
