import java.util.*;

// The complexity will be O(n)
// Will return the index if present or else will return -1
// Generics is used to allow any type of input

public class LinearSearch {

	public <T> int linearSearch(ArrayList<T> inputArray, T searchObj) {


		int index = 0;

		try {

			for(T element : inputArray) {

				if(element.equals(searchObj)) {
					return index;
				}

				index++;
				
			}

		} catch(NullPointerException ex) {

			System.out.println("The value of the array passes is null");
		}

		return -1;

	}

	public static void main(String[] args) {

		LinearSearch searchInstance = new LinearSearch();

		ArrayList<String> inputArray = null;

		inputArray.add("linear");
		inputArray.add("Search");
		inputArray.add("With");
		inputArray.add("Generics");

		int result = searchInstance.linearSearch(inputArray, "With");

		System.out.println("The input is present in the index " + result);

	}
}