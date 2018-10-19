import java.util.*;


// The complexity of the insertion sort is O(n^2)

public class InsertionSort {

	public void iSort(int[] inputArray) {

		int start = 1;
		int end = inputArray.length;

		for(int i = start; i < end; i++) {

			int value = inputArray[i];
			int j = i - 1;

			while(j >= 0 && inputArray[j] > value) {
				
				inputArray[j+1] = inputArray[j];
				j--;
			}

			inputArray[j+1] = value;
		}
	}

	public static void main(String[] args) {

		int[] inputArray = {9, 1, 2, 11, 44, 17};

		InsertionSort sortInstance = new InsertionSort();

		sortInstance.iSort(inputArray);

		for(int elements : inputArray) {

			System.out.println("Print elements after sort : " + elements);
		}
	}
}