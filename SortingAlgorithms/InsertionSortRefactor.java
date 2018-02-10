public class InsertionSortRefactor {

	public static void main(String[] args) {

		int[] array = {1, 2, 8, 4, 6, 11, 50};

		int arrayLength = array.length;

		for(int i = 1; i < arrayLength - 1; i++) {

			int j = i - 1;
			int key = array[i];

			while(j >= 0 && array[j] > key) {

				array[j+1] = array[j];
				--j;
			}

			array[j+1] = key;
		}

		for(int elements : array) {

			System.out.println(elements);
		}
	}
}