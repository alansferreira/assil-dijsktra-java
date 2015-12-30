package assil.algorithms.dijkstra;

public class Edge<V extends Vertex> {
	private final String id;
	private final V source;
	private final V destination;
	private final int weight;

	public Edge(String id, V source, V destination, int weight) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public V getDestination() {
		return destination;
	}

	public V getSource() {
		return source;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return source + " " + destination;
	}

}