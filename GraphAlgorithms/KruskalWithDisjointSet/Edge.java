

import java.util.*;


public class Edge implements Comparable<Edge> {

	Integer source;

	Integer destination;

	Integer weight;

	public Edge() {

		
	}

	public Edge(Integer source, Integer destination, int weight) {

		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}


	public int compareTo(Edge input) {

		return this.weight.compareTo(input.weight);
	}

	public boolean equals(Object input) {

		if(input instanceof Edge) {

			Edge castInput = (Edge) input;

			return this.weight.equals(castInput.weight); 

		}

		return false;
	}


	public int hashCode() {

		return weight.hashCode();
	}

}