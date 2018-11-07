

public class Node {

	public String state;
	public int level;
	public Integer value;
	public Node parent;


	public Node(int value) {

		this.state = "white";
		level = -1;
		this.value = value;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Node value : " + value + " with state : " + state + " having level : " + level);

		return sb.toString();
	}

	public boolean equals(Object inputNode) {

		if(inputNode instanceof Node) {

			Node focusedNode = (Node) inputNode;

			return value.equals(focusedNode.value);
		}

		return false;
	}


	public int hashCode() {

		return value.hashCode();
	}

}