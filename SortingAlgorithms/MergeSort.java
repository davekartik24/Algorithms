public class MergeSort {


	public static void merge(int[] array, int start, int mid, int end) {

		int n1 = mid - start + 1;
		int n2 = end - mid;

		int[] left = new int[n1];
		int[] right = new int[n2];


		for (int i = 0; i < n1; i++) {

			left[i] = array[start + i];
		}

		for (int i = 0; i < n2; i++) {

			right[i] = array[mid + 1 + i];
		}
		int i = 0;
		int j = 0;
		int k = start;

		while(i < n1 && j < n2) {

			if(left[i] <= right[j]) {

				array[k] = left[i];
				++i;

			} else {

				array[k] = right[j];
				++j;
			}

			++k;

		}

		while(i < n1) {

			array[k] = left[i];
			++i;
			++k;
		}

		while(j < n2) {

			array[k] = right[j];
			++j;
			++k;
		}
	}


	public static void sort(int[] array, int start, int end) {


		int mid = (end + start) / 2;

		if(start < end) {

			sort(array, start, mid);
			sort(array, mid+1, end);

			merge(array, start, mid, end);

		}
	}


	public static void main(String[] args) {

		int[] array = {1,43,33,99,23,90};

		int start = 0;
		int end = array.length - 1;

		sort(array, start, end);

		for(int element : array) {

			System.out.println(element);
		}
	}
}