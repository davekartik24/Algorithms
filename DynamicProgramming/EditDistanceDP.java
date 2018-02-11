// Edit Distance

// Input:   str1 = "geek", str2 = "gesek"
// Output:  1
// We can convert str1 into str2 by inserting a 's'.

// Input:   str1 = "cat", str2 = "cut"
// Output:  1
// We can convert str1 into str2 by replacing 'a' with 'u'.

// Input:   str1 = "sunday", str2 = "saturday"
// Output:  3
// Last three and first characters are same.  We basically
// need to convert "un" to "atur".  This can be done using
// below three operations. 
// Replace 'n' with 'r', insert t, insert a


public class EditDistanceDP {

	public static int distance(String s1, String s2, int l1, int l2) {

		int[][] auxArray = new int[l1 + 1][l2 + 1];

		for(int i = 0; i <= l1; i++) {

			for(int j = 0; j <= l2; j++) {

				if(i == 0) {

					auxArray[i][j] = j;

				} else if(j == 0) {

					auxArray[i][j] = i;

				} else if(s1.charAt(i - 1) == s2.charAt(j - 1)) {

					auxArray[i][j] = auxArray[i - 1][j - 1];
				
				} else {

					auxArray[i][j] = 1 + Math.min(auxArray[i][j - 1],Math.min(auxArray[i - 1][j], auxArray[i - 1][j - 1]));
				}

			}
		}

		return auxArray[l1][l2];
	}


	public static void main(String[] args) {

		String s1 = "sunday";
		String s2 = "saturday";

		System.out.println(distance(s1, s2, s1.length(), s2.length()));

	}
} 