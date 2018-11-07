

public class Node {

	public String state;
	public int startTime;
	public int endTime;
	public Integer value;

	public Node(int value) {

		this.state = "white";
		this.value = value;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Node value : " + value + " with state : " + state + " having startTime : " + startTime + " having endTime : " + endTime);

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