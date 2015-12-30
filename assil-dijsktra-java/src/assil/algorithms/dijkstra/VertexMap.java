package assil.algorithms.dijkstra;

import java.util.List;
import java.util.TreeMap;


public class VertexMap<T extends Vertex> extends TreeMap<String, T> {

	private static final long serialVersionUID = -3797161247035701253L;

	public void putAll(List<T> vertexes) {
		for (T vertex : vertexes) {
			super.put(vertex.getName(), vertex);
		}
	}

	public Vertex put(T value) {
		return super.put(value.getName(), value);
	}
	
	
	
}
