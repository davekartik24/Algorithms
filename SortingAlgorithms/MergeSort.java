import java.util.*;

// The run time is O(nlog(n)), can never be improved as comparison tree is made
// Sentinals with value Integer.MAX_VALUE are used in the sort method for ease of loop check

public class MergeSort {


	public void sort(int[] inputArray, int start, int mid, int end) {

		int tempOneLength = (mid - start) + 1;

		int tempTwoLength = end - mid;

		int tempOne[] = new int[tempOneLength + 1];

		int tempTwo[] = new int[tempTwoLength + 1];

		int firstCheck = 0;
		int secondCheck = 0;

		tempOne[tempOneLength] = Integer.MAX_VALUE;
		tempTwo[tempTwoLength] = Integer.MAX_VALUE;

		for(int i = start; i <= mid; i++) {

			tempOne[firstCheck] = inputArray[i];
			firstCheck++;
		}

		for(int j = mid+1; j <= end; j++) {

			tempTwo[secondCheck] = inputArray[j];
			secondCheck++;
		}

		firstCheck = 0;
		secondCheck = 0;

		for(int k = start; k <=end; k++) {
			if(tempOne[firstCheck] <= tempTwo[secondCheck]) {
				inputArray[k] = tempOne[firstCheck];
				firstCheck++;
			} else {
				inputArray[k] = tempTwo[secondCheck];
				secondCheck++;
			}
		}

	}

	public void merge(int[] inputArray, int start, int end) {

		if(start < end) {

			int mid = (start + end)/2;

			merge(inputArray, start, mid);
			merge(inputArray, mid + 1, end);

			sort(inputArray, start, mid, end);

		}
	}


	public void mSort(int[] inputArray) {

		int start = 0;
		int end = inputArray.length - 1;

		merge(inputArray, start, end);
	}

	public static void main(String[] args) {

		MergeSort instanceSort = new MergeSort();

		int[] inputArray = {9, 11, 22, 2, 88, 1};

		instanceSort.mSort(inputArray);

		for(int element : inputArray) {

			System.out.println(element + " ");
		}

	}
}