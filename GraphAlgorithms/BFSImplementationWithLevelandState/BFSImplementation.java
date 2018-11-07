
// As Breadth First Search is a search algorithm
// the input will the point to start the searching(root)
// and the graph(Adjacency List to start the parsing)

// Every Node will be associated with a color and a level

// The runTime complexity of BFS will be O(V+E)

// Assumption : The input Graph will be in the form of Adjacency List

import java.util.*;

public class BFSImplementation {

	public ArrayList<Node> search(HashMap<Node, ArrayList<Node>> graph, Node startNode) {

		ArrayDeque<Node> bfsQueue = new ArrayDeque<>();

		ArrayList<Node> finalList = new ArrayList<>();

		startNode.level = 0;

		startNode.state = "gray";

		bfsQueue.addLast(startNode);


		while(!bfsQueue.isEmpty()) {

			Node focusedNode = bfsQueue.removeFirst();

			System.out.println(focusedNode);

			finalList.add(focusedNode);

			if(graph.containsKey(focusedNode)) {

				for(Node node : graph.get(focusedNode)) {

					if(node.state.equals("white")) {
						
						node.level = focusedNode.level + 1;
						node.parent = focusedNode;
						node.state = "gray";
						bfsQueue.addLast(node);
					}
				}
			}

			focusedNode.state = "black";

		}

		return finalList;

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

		BFSImplementation testInstance = new BFSImplementation();

		testInstance.search(inputGraph, firstNode);
		
	}
}