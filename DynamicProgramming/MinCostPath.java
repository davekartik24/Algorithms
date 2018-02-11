// Min Cost Path
// The path with minimum cost is highlighted in the following figure. 
// 
// 		{1, 2, 3},
//  	{4, 8, 2},
//      {1, 5, 3} 
// 
// 
// The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).

public class MinCostPath {

	public static int minPath(int[][] path,int m,int n) {

		int[][] auxArray = new int[m+1][n+1];

		auxArray[0][0] = path[0][0];

		for(int i = 1; i <= m; i++) {

			auxArray[i][0] = auxArray[i-1][0] + path[i][0];
		}


		for(int j = 1; j <= n; j++) {

			auxArray[0][j] = auxArray[0][j-1] + path[0][j];

		}

		for(int i = 1; i <= m; i++) {

			for(int j = 1; j <= n; j++) {

				auxArray[i][j] = path[i][j] + Math.min(auxArray[i-1][j-1], Math.min(auxArray[i-1][j], auxArray[i][j-1]));
			}

		}

		return auxArray[m][n];
	} 

	public static void main(String[] args) {

		int[][] path = {{1, 2, 3},
                      	{4, 8, 2},
                      	{1, 5, 3} 
                      };


        System.out.println(minPath(path, 2, 2));
	}
}