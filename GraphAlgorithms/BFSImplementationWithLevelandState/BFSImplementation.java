
// As Breadth First Search is a search algorithm
// the input will the point to start the searching(root)
// and the graph(Adjacency List to start the parsing)

// Every Node will be associated with a color and a level

// Assumption : The input Graph will be in the form of Adjacency List

import java.util.*;

public class BFSImplementation {

	public ArrayList<Node> search(HashMap<Node, ArrayList<Node>> graph, Node startNode) {

		ArrayDeque<Node> bfsQueue = new ArrayDeque<>();

		ArrayList<Node> finalList = new ArrayList<>();

		startNode.level = 0;

		bfsQueue.addLast(startNode);


		while(!bfsQueue.isEmpty()) {

			Node focusedNode = bfsQueue.removeFirst();

			System.out.println(focusedNode);

			finalList.add(focusedNode);

			focusedNode.state = "gray";

			if(graph.get(focusedNode) != null) {

				for(Node node : graph.get(focusedNode)) {

					if(node.state.equals("white")) {
						
						node.level = focusedNode.level + 1;
						bfsQueue.addLast(node);
					}
				}
			}

			focusedNode.state = "black";

		}

		return finalList;

	}

	public static void main(String[] args) {

		
	}
}