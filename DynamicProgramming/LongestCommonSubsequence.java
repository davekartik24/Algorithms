// Dynamic Programming | (Longest Common Subsequence)

// Examples:
// LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
// LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.


public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String string1 = "AGGTAB";
		String string2 = "GXTXAYB";

		int m = string1.length();
		int n = string2.length();

		int[][] auxArray = new int[m+1][n+1];


		for(int i = 0; i <= m; i++) {

			for(int j = 0; j <= n; j++) {

				if(i == 0 || j == 0) {

					auxArray[i][j] = 0;
				} else if(string1.charAt(i - 1) == string2.charAt(j - 1)) {

					auxArray[i][j] = auxArray[i-1][j-1] + 1;

				} else {

					auxArray[i][j] = Math.max(auxArray[i-1][j], auxArray[i][j-1]);
				}
			}

		}


		System.out.println(auxArray[m][n]);

	}
}