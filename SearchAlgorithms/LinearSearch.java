public class LinearSearch {

	public static int lSearch(int[] array, int element) {

		for (int i = 0; i < array.length; i++) {

			if (array[i] == element) {

				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		int[] array = {10,31,2,55,66};

		System.out.println("The index of the element is : " + lSearch(array,55));
	}
} 