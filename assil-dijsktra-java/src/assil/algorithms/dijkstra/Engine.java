package assil.algorithms.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * c
 * @author Alan da Silva Ferreira
 * 
 * Classe copiada e adaptada a partir do exemplo: 
 * http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
 * 
 */
public class Engine<V extends Vertex, E extends Edge<V>> {

	private final EdgeMap<V, E> edges;
	private Set<V> settledNodes;
	private Set<V> unSettledNodes;
	private Map<V, V> predecessors;
	private Map<V, Integer> distance;

	public Engine(Graph<V, E> graph) {
		this.edges = graph.getEdges();
	}
 
	public void execute(V source) {
		settledNodes = new HashSet<V>();
		unSettledNodes = new HashSet<V>();
		distance = new HashMap<V, Integer>();
		predecessors = new HashMap<V, V>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			V node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	private void findMinimalDistances(V node) {
		List<V> adjacentNodes = getNeighbors(node);
		for (V target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	private int getDistance(V node, V target) {
		for (Edge<V> edge : edges.values()) {
			if (edge.getSource().getName().equals(node.getName()) && edge.getDestination().getName().equals(target.getName())) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<V> getNeighbors(V node) {
		List<V> neighbors = new ArrayList<V>();
		for (E edge : edges.values()) {
			if (edge.getSource().getName().equals(node.getName()) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	private V getMinimum(Set<V> vertexes) {
		V minimum = null;
		for (V vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(V vertex) {
		return settledNodes.contains(vertex);
	}

	private int getShortestDistance(V destination) {
		Integer d = distance.get(destination);
		if (d == null) return Integer.MAX_VALUE;
		
		return d;
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	public LinkedList<V> getPath(V target) {
		LinkedList<V> path = new LinkedList<V>();
		V step = target;
		// check if a path exists
		if (predecessors.get(step) == null) return null;
		
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

	public List<E> getPathEdges(V target) {
		LinkedList<V> path = getPath(target);
		List<E> ret = new ArrayList<E>();
		
		for (int i = 0; i < path.size()-1 ; i++) {
			ret.add((E) edges.find(path.get(i), path.get(i+1)));
		}
		
		return ret;
	}


}