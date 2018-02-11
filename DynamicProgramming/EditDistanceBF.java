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


public class EditDistanceBF {

	public static int distance(String s1, String s2, int l1, int l2) {

		if(l1 == 0) return l2;

		if(l2 == 0) return l1;

		if(s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {

			return distance(s1, s2, l1 - 1, l2 - 1);
		}

		return 1 + Math.min(distance(s1, s2, l1, l2 -1), 
				   Math.min(distance(s1, s2, l1 - 1, l2), distance(s1, s2, l1 - 1, l2 - 1)));
	}

	public static void main(String[] args) {

		String s1 = "sunday";
		String s2 = "saturday";

		int l1 = s1.length();
		int l2 = s2.length();

		int result = distance(s1, s2, l1, l2);

		System.out.println(result);

	}
}