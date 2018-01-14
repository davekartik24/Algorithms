import java.util.*;

public class QuickSort {


	public static void qSort(int[] array, int start, int end) {

		if(start < end) {

			int partitionPoint = partition(array, start, end);

			qSort(array, start, partitionPoint - 1);
			qSort(array, partitionPoint + 1, end);

		}
	}


	public static int partition(int[] array, int start, int end) {

		int toStart = array[end];

		int i = start;

		for(int j = start; j < end; j++) {

			if(array[j] < toStart) {

				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				++i;
				
			}
		}

		array[end] = array[i];
		array[i] = toStart;
		return i;
	}
 
	public static void main(String[] args) {

		int[] array = {22, 42, 52, 11, 27, 41, 12};

		qSort(array, 0, 6);

		for(int element : array) {

			System.out.println(element);
		}
	}
}