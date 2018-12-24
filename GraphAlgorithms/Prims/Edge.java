

import java.util.*;

public class Edge implements Comparable<Edge>{

	Integer value;
	Edge parent;
	Integer Keyvalue;

	public Edge(Integer value) {

		this.value = value;
		parent = null;
		Keyvalue = Integer.MAX_VALUE;
	}

	public int compareTo(Edge compareEdge) {

		return this.Keyvalue.compareTo(compareEdge.Keyvalue);
	}


	public boolean equals(Object inputEdge) {

		if(inputEdge instanceof Edge) {

			Edge inputEdgeCast = (Edge) inputEdge;

			return this.value.equals(inputEdgeCast.value);
		}

		return false;
	}

	public int hashCode() {

		return value.hashCode();
	}

	public String toString() {

		return "" + value;
	}
}