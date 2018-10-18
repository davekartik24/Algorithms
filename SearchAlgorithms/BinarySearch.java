import java.util.*;

// Divide and Conquer Approach is addopted
// The complexity will be O(log(n)), will require O(nlog(n)) for sorting
// Will return the index if present or else will return -1

public class BinarySearch {

	public int bSearch(int[] inputArray, int toSearch) {

		int start = 0;
		int end = inputArray.length - 1;

		while(start <= end) {

			int mid = start + (end - start)/2;

			if(inputArray[mid] == toSearch) return mid;

			if(inputArray[mid] > toSearch) {

				end = mid - 1;
			} else {

				start = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		BinarySearch instanceSearch = new BinarySearch();

		int inputArray[] = new int[5];

		inputArray[0] = 1;
		inputArray[1] = 10;
		inputArray[2] = 9;
		inputArray[3] = 44;
		inputArray[4] = 17;

		Arrays.sort(inputArray);

		System.out.println("The value is present on index : " + instanceSearch.bSearch(inputArray, 44));

	}
}