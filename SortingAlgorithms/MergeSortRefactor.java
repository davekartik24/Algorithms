import java.util.*;

public class MergeSortRefactor {


	public static void merge(int[] array, int start, int mid, int end) {

		int first = mid - start + 1;
		int second = end - mid;

		int[] firstArray = new int[first + 1];
		int[] secondArray = new int[second + 1];

		firstArray[first] = Integer.MAX_VALUE;
		secondArray[second] = Integer.MAX_VALUE;

		int j = 0;
		int l = 0;

		for(int i = 0; i < first; i++) {

			firstArray[i] = array[start + i];
		}

		for(int i = 0; i < second; i++) {

			secondArray[i] = array[mid + 1 + i];
		}

		for(int k = start; k < end + 1; k++) {

			if(firstArray[j] <= secondArray[l]) {

				array[k] = firstArray[j];
				++j;
			} else {

				array[k] = secondArray[l];
				++l;
			}

		}
	}


	public static void sort(int[] array, int start, int end) {

		if(start < end) {

			int mid = (end + start) / 2;

			sort(array, start, mid);

			sort(array, mid+1, end);

			merge(array,start,mid,end);
		}

	}

	public static void main(String[] args) {

		int[] array = {1, 2, 8, 4, 6, 11, 50};

		int end = array.length - 1;

		int start = 0;

		sort(array, start, end);

		for(int elements : array) {

			System.out.println(elements);
		}
	}
}