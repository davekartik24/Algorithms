import java.util.*;

// The run time of the algorithm is O(nlog(n))
// As a lot of swaps are done which are not leading to the solution to maintain the heapProperty
// the constant factor is really high

public class HeapSort {


	public int parent(int inputIndex) {

		return (inputIndex - 1)/2;
	}

	public int leftChild(int parentIndex) {

		return (2 * parentIndex) + 1;
	}

	public int rightChild(int parentIndex) {

		return leftChild(parentIndex) + 1;
	}

	public void swap(ArrayList<Integer> inputArray, int firstIndex, int secondIndex) {


		int tempValue = inputArray.get(firstIndex);

		inputArray.set(firstIndex, inputArray.get(secondIndex));

		inputArray.set(secondIndex, tempValue);

	}


	public void heapify(ArrayList<Integer> inputArray, int index, int heapSize) {

		int leftChild = leftChild(index);

		int rightChild = rightChild(index);

		int largest;

		if(leftChild <= heapSize && inputArray.get(leftChild) > inputArray.get(index)) {

			largest = leftChild;
		} else {

			largest = index;
		}

		if(rightChild <=heapSize && inputArray.get(rightChild) > inputArray.get(largest)) {

			largest = rightChild;
		}

		if(largest != index) {

			swap(inputArray, index, largest);

			heapify(inputArray, largest, heapSize);
		}
	}

	public void buildMinHeap(ArrayList<Integer> inputArray) {

		int inputSize = inputArray.size() - 1;

		if(inputSize < 1) return;

		int lastParent = parent(inputSize);

		while(lastParent >= 0) {

			heapify(inputArray, lastParent, inputSize);
			lastParent--;
		}

	}



	public void hSort(ArrayList<Integer> inputArray) {

		int inputSize = inputArray.size() - 1;
		buildMinHeap(inputArray);
		for(int i = 0; i < inputArray.size(); i++) {
			swap(inputArray, 0, inputSize);		
			inputSize--;
			heapify(inputArray, 0, inputSize);
		}

	}

	public static void main(String[] args) {

		HeapSort sortInstance = new HeapSort();

		ArrayList<Integer> inputArray = new ArrayList<Integer>();

		inputArray.add(10);
		inputArray.add(2);
		inputArray.add(9);
		inputArray.add(1);
		inputArray.add(7);
		inputArray.add(22);
		inputArray.add(15);

		sortInstance.hSort(inputArray);

		for(int element : inputArray) {

			System.out.println(element + " ");
		}


	}
}