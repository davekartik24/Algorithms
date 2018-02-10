public class JumpSearch {

	public static void main(String[] args) {

		int[] input = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};

		int key = 610;

		int jump = (int)Math.sqrt(input.length);

		int i = jump;

		int resultIndex = -1;

		while(i < input.length) {

			if(input[i] == key) {

				resultIndex = i;
				break;
			}

			if(input[i] > key) {

				break;
			}

			if(input[i] < key) {

				i += jump;
			}
		}

		if(resultIndex == -1) {

			for(int j = i - jump; j < Math.min(input.length, i); j++) {

				if(input[j] == key) {

					resultIndex = j;
					break;
				}
			}
		}

		System.out.println(resultIndex);
	}
}