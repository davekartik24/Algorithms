import java.util.*;


// The run time of the sort will be Theta of n^2

public class SelectionSort {

	public void sSort(int[] inputArray) {

		int length = inputArray.length;
		int smallest;
		int smallestIndex;


		for(int i = 0; i < length - 1; i++) {

			smallest = Integer.MAX_VALUE;
			smallestIndex = -1;
			for(int j = i; j < length; j++) {

				if(inputArray[j] < smallest) {

					smallest = inputArray[j];
					smallestIndex = j;
				}
			}

			inputArray[smallestIndex] = inputArray[i];
			inputArray[i] = smallest;
		}
	}


	public static void main(String[] args) {

		SelectionSort instaceSort = new SelectionSort();

		int[] inputArray = {9, 11, 22, 2, 88, 1};

		instaceSort.sSort(inputArray);

		for(int element : inputArray) {

			System.out.println(element + " ");
		}

	}
}