

import java.util.*;
import java.io.*;

public class TopologicalSort {

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

	public void sortTopologically(HashMap<Integer, ArrayList<Integer>> inputGraph) {

		HashSet<Integer> root = findRoot(inputGraph);

		LinkedList<Integer> result = new LinkedList<>();

		for(Integer rootElement : root) {

			sort(inputGraph, rootElement, result);

		}

		for(Integer resultElement : result) {

			System.out.println(resultElement);
		}
	}


	public void sort(HashMap<Integer, ArrayList<Integer>> inputGraph, Integer root, LinkedList<Integer> result) {

		if(inputGraph.get(root) != null) {

			for(Integer edges : inputGraph.get(root)) {

				sort(inputGraph, edges, result);

			}

		}

		if(!result.contains(root)) result.addFirst(root);

	}

	public HashSet findRoot(HashMap<Integer, ArrayList<Integer>> inputGraph) {

		HashSet<Integer> valuesSet = new HashSet<>();

		HashSet<Integer> rootList = new HashSet<>();

		for(ArrayList<Integer> valElement : inputGraph.values()) {

			for(Integer element : valElement) {

				valuesSet.add(element);	
			}
			
		}

		for(Integer key : inputGraph.keySet()) {

			if(!valuesSet.contains(key)) rootList.add(key);
		}

		return rootList;
	}


	public static void main(String[] args) {

		TopologicalSort testInstance = new TopologicalSort();

		HashMap<Integer, ArrayList<Integer>> graph = testInstance.toGraphFromFile("C:/Users/Kartik/Documents/Summer2019/Git/Algorithms/GraphAlgorithms/TopologicalSort/InputGraph.txt");

		testInstance.sortTopologically(graph);
	}
}