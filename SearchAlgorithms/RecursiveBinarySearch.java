import java.util.*;

// Divide and Conquer Approach is addopted
// The complexity will be O(log(n)), will require O(nlog(n)) for sorting (Used Comparator logic for Sorting)
// Will return the index if present or else will return -1

public class RecursiveBinarySearch implements Comparator<Integer> {

	public  int bSearch(ArrayList<Integer> inputArray, int searchObj) {

		int end = inputArray.size();

		return search(inputArray, 0, end - 1, searchObj);
	}


	public int search(ArrayList<Integer> inputArray, int start, int end, int searchObj) {

		if(start <= end) {
			
			// The reson why it is not done as start+end/2 is when Integer overflow will happen
			// An incorrect output will happen.
			
			int mid = start + (end - start)/2;

			if(searchObj == inputArray.get(mid)) return mid;

			if(searchObj > inputArray.get(mid)) {

				return search(inputArray, mid + 1, end, searchObj);
			} else {

				return search(inputArray, start, mid - 1, searchObj);
			}
		}

		return -1;
	}

	public int compare(Integer one, Integer two) {

		int oneValue = one;
		int secondValue = two;

		if(one > two) { 
			return 1;
		} else if(one == two) {
			return 0;
		} else return -1;
	}
	

	public static void main(String[] args) {

		RecursiveBinarySearch instanceTest = new RecursiveBinarySearch();

		ArrayList<Integer> inputArray = new ArrayList<>();

		inputArray.add(10);
		inputArray.add(22);
		inputArray.add(15);
		inputArray.add(30);

		inputArray.sort(instanceTest);

		int searchObj = 22;

		System.out.println("The index at which the value is present is : " + instanceTest.bSearch(inputArray, searchObj));
	}
}