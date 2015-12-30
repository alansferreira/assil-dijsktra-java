package assil.algorithms.dijkstra;

import java.util.List;
import java.util.TreeMap;


public class EdgeMap<V extends Vertex, E extends Edge<V>> extends TreeMap<String, E> {

	private static final long serialVersionUID = -3797161247035701253L;

	public void putAll(List<E> edges) {
		for (E edge : edges) {
			super.put(edge.getId(), edge);
		}
	}

	public Edge<V> put(E value) {
		return super.put(value.getId(), value);
	}
	public Edge<V> find(V source, V destination){
		
		for (Edge<V> edge : this.values()) {
			if(edge.getSource().getName().equals(source.getName()) && edge.getDestination().getName().equals(destination.getName())) return edge;
		}
		
		return null;
	}
	
	
}
