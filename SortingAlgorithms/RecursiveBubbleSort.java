import java.util.*;

public class RecursiveBubbleSort {

	public void rbSort(int[] inputArray, int start, int end) {

		if(end == 0) return;

		if(start == end) {

			rbSort(inputArray, 0, end - 1);

		} else if(inputArray[start] > inputArray[start + 1]) {

			int temp = inputArray[start];
			inputArray[start] = inputArray[start + 1];
			inputArray[start + 1] = temp;
			rbSort(inputArray, ++start, end);

		} else {

			rbSort(inputArray, ++start, end);
		}

	}


	public static void main(String[] args) {

		RecursiveBubbleSort instaceSort = new RecursiveBubbleSort();

		int[] inputArray = {9, 11, 22, 2, 88, 1};

		instaceSort.rbSort(inputArray, 0, inputArray.length - 1);

		for(int element : inputArray) {

			System.out.println(element + " ");
		}
	}
}