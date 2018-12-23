
import java.util.*;

public class Kruskal {

	public void mstKruskal(ArrayList<Edge> inputEdgeList) {

		ArrayList<Edge> resultList = new ArrayList<>();

		Collections.sort(inputEdgeList);

		HashMap<Integer, Integer> parent = initializeParent(inputEdgeList);

		for(Edge e : inputEdgeList) {

			Integer sourceParent = find(e.source, parent);
			Integer destinationParent = find(e.destination, parent);

			if(sourceParent != destinationParent) {

				resultList.add(e);
				union(sourceParent, destinationParent, parent);
			}
		}

		for(Edge e : resultList) {

			System.out.println("Source: " + e.source + " --> destination: " + e.destination);
		} 
	}

	public void union(Integer inputE1, Integer inputE2, HashMap<Integer, Integer> parentLookUp) {

		parentLookUp.put(inputE1, inputE2);
	}

	public Integer find(Integer inputV, HashMap<Integer, Integer> parentLookUp) {

		if(parentLookUp.get(inputV) == -1) return inputV;

		return find(parentLookUp.get(inputV), parentLookUp);
	}

	public HashMap<Integer, Integer> initializeParent(ArrayList<Edge> inputEdgeList) {

		HashMap<Integer, Integer> parent = new HashMap<>();

		for(Edge e : inputEdgeList) {

			if(!parent.containsKey(e.source)) {

				parent.put(e.source, -1);
			}

			if(!parent.containsKey(e.destination)) {

				parent.put(e.destination, -1);
			}
		}

		return parent;
	}





	public static void main(String[] args) {

		Kruskal testInstance = new Kruskal();

		ArrayList<Edge> inputEdgeList = new ArrayList<>();

		Edge edge0 = new Edge(); 
		edge0.source = 0; 
        edge0.destination = 1; 
        edge0.weight = 10; 
  
        // add edge 0-2 
        Edge edge1 = new Edge();
        edge1.source = 0; 
        edge1.destination = 2; 
        edge1.weight = 6; 
  
        // add edge 0-3 
        Edge edge2 = new Edge();
        edge2.source = 0; 
        edge2.destination = 3; 
        edge2.weight = 5; 
  
        // add edge 1-3 
        Edge edge3 = new Edge();
        edge3.source = 1; 
        edge3.destination = 3; 
        edge3.weight = 15; 
  
        // add edge 2-3 
        Edge edge4 = new Edge();
        edge4.source = 2; 
        edge4.destination = 3; 
        edge4.weight = 4; 

        inputEdgeList.add(edge0);
        inputEdgeList.add(edge1);
        inputEdgeList.add(edge2);
        inputEdgeList.add(edge3);
        inputEdgeList.add(edge4);

        testInstance.mstKruskal(inputEdgeList);

	}


}