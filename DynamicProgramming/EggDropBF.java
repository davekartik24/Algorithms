// Egg Dropping Puzzle


import java.util.*;

public class EggDropBF {

	public static int requiredFloor(int egg, int floor) {

		if(floor == 1 || floor == 0) {

			return floor;
		}

		if(egg == 1) {

			return floor;
		}

		int min = Integer.MAX_VALUE;
		int maxJumps;

		for(int x = 1; x <= floor; x++) {

			maxJumps = Math.max(requiredFloor(egg - 1, x - 1), requiredFloor(egg, floor - x));

			if(maxJumps < min) min = maxJumps;
		}

		return min + 1;
	}

	public static void main(String[] args) {

		int egg = 2;
		int floor = 10;

		int minFloor = requiredFloor(egg, floor);

		System.out.println(minFloor);
	}
}