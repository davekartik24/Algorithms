
import java.util.*;

public class MinCostPathBF {

	public static int pathFinder(int[][] path, int m, int n) {

		if(m < 0 || n < 0) {

			return Integer.MAX_VALUE;

		} else if (m == 0 && n == 0) {

			return path[m][n];

		} else {

		return path[m][n] + Math.min(pathFinder(path, m - 1, n - 1), Math.min(pathFinder(path, m - 1, n), pathFinder(path, m, n - 1)));

		}
	}

	public static void main(String[] args) {

		int[][] path = {{1, 2, 3},
                      	{4, 8, 2},
                      	{1, 5, 3} 
                      };

        System.out.println(pathFinder(path, 2, 2));


	}
}