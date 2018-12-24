
import java.util.*;

public class PrimsMST {


	public void primsAlgo(HashMap<Edge, ArrayList<LinkEdge>> inputGraph) {

		// to assign a value as 0 to key to one of the edge, to select as a stating point


		PriorityQueue<Edge> safeEdge = new PriorityQueue<>();

		for(Edge e : inputGraph.keySet()) {

			if(!safeEdge.contains(e)) {

				safeEdge.add(e);
			}
		}

		Edge sourceEdge = safeEdge.peek();

		sourceEdge.Keyvalue = 0;

		ArrayList<Edge> result = new ArrayList<>();

		while(!safeEdge.isEmpty()) {

			Edge edgeSource = safeEdge.poll();

			System.out.println(edgeSource);

			result.add(edgeSource);

			for(LinkEdge linkElement : inputGraph.get(edgeSource)) {

				if(safeEdge.contains(linkElement.linkNode) && linkElement.linkNode.Keyvalue > linkElement.weight) {

					linkElement.linkNode.parent = edgeSource;
					linkElement.linkNode.Keyvalue = linkElement.weight;	

				}
			}

		} 

	}

	public void printThePath(Edge lastEdge) {

		if(lastEdge != null) {

			printThePath(lastEdge.parent);
		}
	} 

	public static void main(String[] args) {

		PrimsMST testInstance = new PrimsMST();

		HashMap<Edge, ArrayList<LinkEdge>> graph = new HashMap<>();

		Edge one = new Edge(0);
		Edge two = new Edge(1);
		Edge three = new Edge(2);
		Edge four = new Edge(3);
		Edge five = new Edge(4);

		LinkEdge firstOne = new LinkEdge(two, 2);
		LinkEdge secondOne = new LinkEdge(four, 6);
		LinkEdge firstTwo = new LinkEdge(one, 2);
		LinkEdge secondTwo = new LinkEdge(three, 3);
		LinkEdge thirdTwo = new LinkEdge(four, 8);
		LinkEdge fourthTwo = new LinkEdge(five, 5);
		LinkEdge firstThree = new LinkEdge(two, 3);
		LinkEdge secondThree = new LinkEdge(five, 7);
		LinkEdge firstFour = new LinkEdge(one, 6);
		LinkEdge secondFour = new LinkEdge(two, 8);
		LinkEdge thirdFour = new LinkEdge(five, 9);
		LinkEdge firstFive = new LinkEdge(two, 5);
		LinkEdge secondFive = new LinkEdge(three, 7);
		LinkEdge thirdFive = new LinkEdge(four, 9);

		ArrayList<LinkEdge> inputEdgeOne =  new ArrayList<>();

		inputEdgeOne.add(firstOne);
		inputEdgeOne.add(secondOne);

		ArrayList<LinkEdge> inputEdgeTwo =  new ArrayList<>();

		inputEdgeTwo.add(firstTwo);
		inputEdgeTwo.add(secondTwo);
		inputEdgeTwo.add(thirdTwo);
		inputEdgeTwo.add(fourthTwo);


		ArrayList<LinkEdge> inputEdgeThree =  new ArrayList<>();

		inputEdgeThree.add(firstThree);
		inputEdgeThree.add(secondThree);


		ArrayList<LinkEdge> inputEdgeFour =  new ArrayList<>();

		inputEdgeFour.add(firstFour);
		inputEdgeFour.add(secondFour);
		inputEdgeFour.add(thirdFour);


		ArrayList<LinkEdge> inputEdgeFive =  new ArrayList<>();

		inputEdgeFive.add(firstFive);
		inputEdgeFive.add(secondFive);
		inputEdgeFive.add(thirdFive);

		graph.put(one, inputEdgeOne);
		graph.put(two, inputEdgeTwo);
		graph.put(three, inputEdgeThree);
		graph.put(four, inputEdgeFour);
		graph.put(five, inputEdgeFive);

		testInstance.primsAlgo(graph);
		
	}
}