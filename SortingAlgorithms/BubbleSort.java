public class BubbleSort {

	public static void main(String[] args) {

		int[] array = {1,2,3,4,5,6};

		boolean reduce = false;

		for(int i = 0; i < array.length - 1; i++) {

			for(int j = 0; j < array.length - i - 1; j++) {

				if(array[j] > array[j+1]) {
					reduce = true;
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;

				}

			}

			if (reduce == false) {
				break;
			}
			
		}

		for(int elements : array) {

			System.out.println(elements + " ");
		}
	}
}