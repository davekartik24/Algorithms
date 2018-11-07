
import java.util.*;

public class DFSImplementationWithStack{

	public int time;

	public void search(HashMap<Node, ArrayList<Node>> inputGraph, Node startNode) {

		ArrayDeque<Node> stack = new ArrayDeque<>();

		stack.addLast(startNode);


		while(!stack.isEmpty()) {

			Node focusedNode = stack.removeLast();

			if(focusedNode.state.equals("white")) {

				++time;

				focusedNode.startTime = time;

				focusedNode.state = "gray";

				stack.addLast(focusedNode);

				if(inputGraph.containsKey(focusedNode)) {

					for(Node edges : inputGraph.get(focusedNode)) {

						if(edges.state.equals("white")) {

							stack.addLast(edges);
						}
					}
				}

			} else if(focusedNode.state.equals("gray")) {

				focusedNode.state = "black";
				++time;
				focusedNode.endTime = time;

				System.out.println(focusedNode);
			}
		}

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

		DFSImplementationWithStack testInstance = new DFSImplementationWithStack();

		testInstance.search(inputGraph, firstNode);
	}
}