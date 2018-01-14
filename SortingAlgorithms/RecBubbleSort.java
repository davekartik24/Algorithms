public class RecBubbleSort {


	public static int[] bubSort(int[] array, int start, int end) {

		if(end == 0) {

			return array;
		}

		if(start == end) {

			return bubSort(array, 0, end - 1);
		}

		if(array[start] > array[start + 1]) {

			int temp = array[start];
			array[start] = array[start+1];
			array[start+1] = temp;

			bubSort(array, start+1, end);
		}

		return bubSort(array, start+1, end);
	}

	public static void main(String[] args) {

		int[] array = {13, 65, 65, 62,61,1,10,15};

		int end = array.length - 1;

		int [] result = bubSort(array, 0, end);

		for (int elements : result) {

			System.out.println(elements + " ");
		}
	}
}