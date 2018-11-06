

public class Node {

	public String state;
	public int level;
	public int value;


	public Node(int value) {

		this.state = "white";
		level = -1;
		this.value = value;
	}

}