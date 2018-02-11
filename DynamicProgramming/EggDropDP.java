// Egg Dropping Puzzle


public class EggDropDP {

	public static int requiredFloor(int egg, int floor) {

		int[][] auxArray = new int[egg+1][floor+1];
		int maxFind;


		for(int j = 1; j <= egg; j++) {

			auxArray[j][1] = 1;
			auxArray[j][0] = 0;
			
		}

		for(int i = 1; i <= floor; i++) {

			auxArray[1][i] = i;

		}


		for(int i = 2; i <= egg; i++) {

			for(int j = 2; j <= floor; j++) {

				auxArray[i][j] = Integer.MAX_VALUE;

				for(int k = 1; k <= j; k++) {

					maxFind = 1 + Math.max(auxArray[i - 1][k - 1], auxArray[i][j - k]);

					if(maxFind < auxArray[i][j]) {

						auxArray[i][j] = maxFind;
					}

				}
			}
		}

		return auxArray[egg][floor];

	}

	public static void main(String[] args) {

		int egg = 2;
		int floor = 10;

		int minFloor = requiredFloor(egg, floor);

		System.out.println(minFloor);
	}
}