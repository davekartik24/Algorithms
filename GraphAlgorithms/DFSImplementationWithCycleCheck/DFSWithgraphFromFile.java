import java.util.*;
import java.io.*;


public class DFSWithgraphFromFile {

	boolean finalCall = false;

	public HashMap<Integer, ArrayList<Integer>> toGraphFromFile(String filePath) {

		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

		try {

			File inputFile = new File(filePath);

			FileReader fr = new FileReader(inputFile);

			BufferedReader br = new BufferedReader(fr);

			String fileData = null;

			while((fileData = br.readLine()) != null) {

				String[] keyValue = fileData.split(":");

				String[] value = keyValue[1].split(",");

				ArrayList<Integer> keys = new ArrayList<>();

				for(String v : value) {

					keys.add(Integer.parseInt(v));
				}

				graph.put(Integer.parseInt(keyValue[0]), keys);

			} 

		} catch(Exception ex) {

				System.out.println(ex.getMessage());
		}

		return graph;
	}

	public boolean DFS(HashMap<Integer, ArrayList<Integer>> inputGraph) {

		int root = findRoot(inputGraph);

		HashSet<Integer> cycleDetectSet = new HashSet<>();

		DFSImplementation(root, inputGraph, cycleDetectSet);

		return finalCall;
	}


	public void DFSImplementation(int root, HashMap<Integer, ArrayList<Integer>> inputGraph, HashSet<Integer> cycleDetectSet) {

		System.out.println(root);

		cycleDetectSet.add(root);

		if(inputGraph.get(root) != null) {

			for(Integer element : inputGraph.get(root)) {

				if(cycleDetectSet.contains(element)) {
					finalCall = true;
				}

				DFSImplementation(element, inputGraph, cycleDetectSet);
			}

		}
	}


	public int findRoot(HashMap<Integer, ArrayList<Integer>> inputGraph) {

		HashSet<Integer> values = new HashSet<Integer>();

		for(Integer key : inputGraph.keySet()) {

			for(Integer value : inputGraph.get(key)) {

				values.add(value);
			}

		}

		for(Integer key : inputGraph.keySet()) {

			if(!values.contains(key)) return key;
		}

		return -1;

	}


	public static void main(String[] args) {

		DFSWithgraphFromFile testInstance = new DFSWithgraphFromFile();

		HashMap<Integer, ArrayList<Integer>> graph =  testInstance.toGraphFromFile("C:/Users/Kartik/Documents/Summer2019/Git/Algorithms/GraphAlgorithms/DFSImplementationWithCycleCheck/inputGraph.txt");

		System.out.println("is the cycle present -> " + testInstance.DFS(graph));
	}
}