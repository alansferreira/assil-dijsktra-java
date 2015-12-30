package org.assil.jax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import assil.algorithms.dijkstra.Edge;
import assil.algorithms.dijkstra.Vertex;
/**
 * c
 * @author Alan da Silva Ferreira
 * 
 */

@XmlRootElement
public class Rota {
	
	private double custoTotal = 0; 
	private double distanciaTotal = 0;
	
	public double getDistanciaTotal() {
		return distanciaTotal;
	}
	public void setDistanciaTotal(double distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}
	public double getCustoTotal() {
		return custoTotal;
	}
	public void setCustoTotal(double custoTotal) {
		this.custoTotal = custoTotal;
	}
	public List<String> getCaminho() {
		return caminho;
	}
	public void setCaminho(List<String> caminho) {
		this.caminho = caminho;
	}
	private List<String> caminho = new ArrayList<String>();
	public Rota(List<Edge<Vertex>> path, double autonomia, double custolitro) {
		
		distanciaTotal = 0;
		
		for (int i = 0; i < path.size(); i++) {
			Edge<Vertex> edge = path.get(i);
			
			this.distanciaTotal += edge.getWeight();			

			if(i==0) caminho.add(edge.getSource().getName());
			
			this.caminho.add(edge.getDestination().getName());
		}

		this.custoTotal += ((this.distanciaTotal/autonomia)*custolitro);
		
		
	}

}
