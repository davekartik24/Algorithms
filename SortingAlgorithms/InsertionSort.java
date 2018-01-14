public class InsertionSort {

	public static void main(String[] args) {

		int[] array = {65, 62, 1, 5, 99};

		for (int i = 1; i < array.length; i++) {

			int elementToInsert = array[i];

			int j = i - 1;

			while (j >= 0 && array[j] > elementToInsert) {

				array[j+1] = array[j];

				--j;
			}

			array[j+1] = elementToInsert;

		}

		for(int element : array) {

			System.out.println(element + " ");
		}
	}
}