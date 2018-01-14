public class InsertionSort {

	public static void main(String[] args) {

		int[] array = {61,12,15,1,10};

		for (int i = 0; i < array.length; i++) {

			int index = i;

			for (int j = i+1; j < array.length; j++) {

				if(array[index] > array[j]) {

					int temp = array[index];
					array[index] = array[j];
					array[j] = temp;
				}
			}
		}

		for(int elements : array) {

			System.out.print(elements + " ");
		}
	}
}