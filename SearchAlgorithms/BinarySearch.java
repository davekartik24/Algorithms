public class BinarySearch {


	public static int divideAndRule(int[] array, int start, int end, int search) {

		if (end >=  start) {

			int mid = start + (end - start)/2;

			if (array[mid] == search) {

				return mid;
			}

			if (array[mid] > search) {

				return divideAndRule(array, start, mid-1, search);
			}

			return divideAndRule(array, mid+1, end, search);

		}

		return -1;
	}

	public static void main(String[] args) {

		int[] array = {1,2,3,4,5,6,7};

		int length = array.length;

		int result = divideAndRule(array,0,length-1,6);

		System.out.println(result);
	}

}