import java.util.*;

// The run time of the QuickSort Theta of nlog(n) but with O(n^2)
// The worst case depends on the selection of the partition index
// Even if the best to worst ratio is 1:99 still it will give nlog(n) behaviour
// Used Randomization for selecting the partition element 

public class QuickSort{


	public void randomPartitionElement(int[] inputArray, int start, int end) {

		int limit = (end - start);

		int randomIndex = (int)(Math.random() * limit);

		int temp = inputArray[randomIndex];
		inputArray[randomIndex] = inputArray[end];
		inputArray[end] = temp; 
	}


	public int partition(int[] inputArray, int start, int end) {

		int index = start;

		randomPartitionElement(inputArray,start, end); 

		int compareElement = inputArray[end];

		for(int i = start; i < end; i++) {

			if(inputArray[i] < compareElement) {

				int temp = inputArray[i];
				inputArray[i] = inputArray[index];
				inputArray[index] = temp;
				index++;

			}
		}

		inputArray[end] = inputArray[index];
		inputArray[index] = compareElement;

		return index;
	}


	public void quickSort(int[] inputArray, int start, int end) {

		if(start < end) {

			int partitionIndex = partition(inputArray, start, end);

			quickSort(inputArray, start, partitionIndex - 1);
			quickSort(inputArray, partitionIndex + 1, end);
		}
	}

	public void qSort(int[] inputArray) {

		int start = 0;
		int end = inputArray.length - 1;

		quickSort(inputArray, start, end);
	}

	public static void main(String[] args) {

		QuickSort instanceSort = new QuickSort();

		int[] inputArray = {9, 11, 22, 2, 88, 1};

		instanceSort.qSort(inputArray);


		for(int element : inputArray) {

			System.out.println(element + " ");
		}
	}
}