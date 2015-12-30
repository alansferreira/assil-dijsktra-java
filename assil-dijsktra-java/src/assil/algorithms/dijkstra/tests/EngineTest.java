package assil.algorithms.dijkstra.tests;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import assil.algorithms.dijkstra.Edge;
import assil.algorithms.dijkstra.EdgeMap;
import assil.algorithms.dijkstra.Engine;
import assil.algorithms.dijkstra.Graph;
import assil.algorithms.dijkstra.Vertex;
import assil.algorithms.dijkstra.VertexMap;

public class EngineTest {
	
	VertexMap<Vertex> vertexes = new VertexMap<Vertex>();
	EdgeMap<Vertex, Edge<Vertex>> edges = new EdgeMap<Vertex, Edge<Vertex>>();
	
	
	
	@Before
	public void setUp(){
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
		
	}
	
	@Test
	public void testExecute() {
		
		Graph<Vertex, Edge<Vertex>> graph = new Graph<Vertex, Edge<Vertex>>(vertexes, edges);
		
		Engine<Vertex, Edge<Vertex>> engine = new Engine<Vertex, Edge<Vertex>>(graph);
		
		engine.execute(vertexes.get("A"));
	    
	    LinkedList<Vertex> path = engine.getPath(vertexes.get("E"));
	    
	    for (Vertex vertex : path) {
	      System.out.println(vertex);
	    }
		
	}


}
