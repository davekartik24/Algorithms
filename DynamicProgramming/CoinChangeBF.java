public class CoinChangeBF {

	public static int possibleCases(int[] change, int m, int value) {

		if(value == 0) {

			return 1;
		}

		if(value >= 1 && m <= 0) {

			return 0;
		}

		if(value < 0) {

			return 0;
		}


		return possibleCases(change, m - 1, value) + possibleCases(change, m, (value - change[m - 1]));
	}

	public static void main(String[] args) {


		int[] change = {1,2};

		int value = 3;

		System.out.println(possibleCases(change, change.length, value));
	}
}