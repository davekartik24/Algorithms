

import java.util.*;

public class DFSImplementationWithRecursion {

	int time;

	public void search(HashMap<Node, ArrayList<Node>> inputGraph, Node startNode) {

		startNode.state = "gray";
		++time;

		startNode.startTime = time;

		if(inputGraph.containsKey(startNode)) {

			for(Node edges : inputGraph.get(startNode)) {

				if(edges.state.equals("white")) {

					search(inputGraph, edges);
				}
			}
		}

		++time;
		startNode.endTime = time;
		startNode.state = "black";

		System.out.println(startNode);

	}

	public static void main(String[] args) {

		Node firstNode = new Node(1);
		Node secondNode = new Node(3);
		Node thirdNode = new Node(4);
		Node fourthNode = new Node(5);
		Node fifthNode = new Node(6);

		ArrayList<Node> firstEdgeList = new ArrayList<>();
		firstEdgeList.add(thirdNode);
		firstEdgeList.add(fourthNode);

		ArrayList<Node> secondEdgeList = new ArrayList<>();
		secondEdgeList.add(thirdNode);
		secondEdgeList.add(fourthNode);

		ArrayList<Node> thirdEdgeList = new ArrayList<>();
		thirdEdgeList.add(secondNode);
		thirdEdgeList.add(fourthNode);
		thirdEdgeList.add(fifthNode);
		thirdEdgeList.add(firstNode);

		ArrayList<Node> fourthEdgeList = new ArrayList<>();
		fourthEdgeList.add(secondNode);
		fourthEdgeList.add(thirdNode);
		fourthEdgeList.add(fifthNode);
		fourthEdgeList.add(firstNode);

		ArrayList<Node> fifthEdgeList = new ArrayList<>();
		fourthEdgeList.add(thirdNode);
		fourthEdgeList.add(fourthNode);


		HashMap<Node, ArrayList<Node>> inputGraph = new HashMap<>();

		inputGraph.put(firstNode, firstEdgeList);
		inputGraph.put(secondNode, secondEdgeList);
		inputGraph.put(thirdNode, thirdEdgeList);
		inputGraph.put(fourthNode, fourthEdgeList);
		inputGraph.put(fifthNode, fifthEdgeList);

		DFSImplementationWithRecursion testInstance = new DFSImplementationWithRecursion();

		testInstance.search(inputGraph, firstNode);
		
	}
}