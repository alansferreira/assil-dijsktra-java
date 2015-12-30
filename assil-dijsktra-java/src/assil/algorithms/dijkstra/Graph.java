package assil.algorithms.dijkstra;

import java.util.List;
/**
 * d
 * @author Alan da Silva Ferreira
 * 
 * Classe copiada e adaptada a partir do exemplo: 
 * http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
 * 
 */

public class Graph<V extends Vertex, E extends Edge<V>> {
	private VertexMap<V> vertexes = new VertexMap<V>();
	private EdgeMap<V, E> edges = new EdgeMap<V, E>();

	public Graph(List<V> vertexes, List<E> edges) {
		this.vertexes.putAll(vertexes);
		this.edges.putAll(edges);
	}

	public Graph(VertexMap<V> vertexes, EdgeMap<V, E> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public VertexMap<V> getVertexes() {
		return vertexes;
	}

	public EdgeMap<V, E> getEdges() {
		return edges;
	}

}
