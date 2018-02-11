// Coin Change

// For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
// So output should be 4. 
// For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
// So the output should be 5.


public class CoinChangeDP {

	public static int possibleCases(int[] change, int currency, int value) {

		int[] auxArray = new int[value + 1];

		auxArray[0] = 1;

		for(int i = 0; i < currency; i++) {

			for(int j = change[i]; j <= value; j++) {

				auxArray[j] += auxArray[(j - change[i])];
			}
		}

		return auxArray[value]; 
	}


	public static void main(String[] args) {

		int[] change = {1,2};

		int value = 3;

		System.out.println(possibleCases(change, change.length, value));
	}
	
}