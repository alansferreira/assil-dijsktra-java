package de.vogella.algorithms.dijkstra.tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import de.vogella.algorithms.dijkstra.engine.DijkstraAlgorithm;
import de.vogella.algorithms.dijkstra.model.Edge;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.Vertex;

public class DijkstraAlgorithmTest {
	private List<Vertex> nodes;
	private List<Edge> edges;

	@Test
	public void test() {

		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		
		nodes.add(new Vertex("A", "A"));
		nodes.add(new Vertex("B", "B"));
		nodes.add(new Vertex("C", "C"));
		nodes.add(new Vertex("D", "D"));
		nodes.add(new Vertex("E", "E"));

		addLane("Edge_0", 0, 1, 10);
		addLane("Edge_1", 1, 3, 15);
		addLane("Edge_2", 0, 2, 20);
		addLane("Edge_3", 2, 3, 30);
		addLane("Edge_4", 1, 4, 10);
		addLane("Edge_5", 3, 4, 30);
//		A B 10
//		B D 15
//		A C 20
//		C D 30
//		B E 50
//		D E 30
		
		
		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(nodes.get(0));
		LinkedList<Vertex> path = dijkstra.getPath(nodes.get(4));

		for (Vertex vertex : path) {
			System.out.println(vertex);
		}

	}
	
	
	private void addLane(String laneId, int sourceLocNo, int destLocNo,
			int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo),
				nodes.get(destLocNo), duration);
		edges.add(lane);
	}
}
