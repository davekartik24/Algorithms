import java.util.*;


// The complexity of the insertion sort is O(n^2)

public class BubbleSort {

	public void bSort(int[] inputArray) {

		int arrayLength = inputArray.length;

		boolean noChangeFlag; 

		for(int i = 1; i < arrayLength; i++) {

			noChangeFlag = true;

			for(int j = 1; j <= arrayLength - i; j++) {

				noChangeFlag = false;

				if(inputArray[j-1] > inputArray[j]) {

					int temp = inputArray[j-1];
					inputArray[j-1] = inputArray[j];
					inputArray[j] = temp;
				}
			}

			if(noChangeFlag) break;
		}

	}

	public static void main(String[] args) {

		BubbleSort instanceSort = new BubbleSort();

		int[] inputArray = {9, 11, 22, 2, 88, 1};

		instanceSort.bSort(inputArray);

		for(int element : inputArray) {

			System.out.print(element + " ");
		}

	}
}