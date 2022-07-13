package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfBurgersWithNoWasteOfIngredients {
	
	public static void main(String[] args) {
		List<Integer> res = numOfBurgers(16, 7);
		System.out.println(res);
	}
	
	/**
	 * jumbo + small = cheese
	 * jumbo * 2 + small = tomato / 2
	 * jumbo = tomato / 2 - cheese
	 */
	public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		return tomatoSlices % 2 == 0 && tomatoSlices >= cheeseSlices * 2 && tomatoSlices <= cheeseSlices * 4 ?
				Arrays.asList(tomatoSlices / 2 - cheeseSlices, 2 * cheeseSlices - tomatoSlices / 2) : new ArrayList<>();
	}

//	public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
//		int lo = 0, hi = tomatoSlices / 4;
//		while (lo <= hi) {
//			int jumboCount = (lo + hi) / 2;
//			int tomatoLeft = tomatoSlices - jumboCount * 4;
//			int cheeseLeft = cheeseSlices - jumboCount;
//			if (tomatoLeft == cheeseLeft * 2) {
//				return Arrays.asList(jumboCount, cheeseLeft);
//			} else if (tomatoLeft > cheeseLeft * 2) {
//				lo = jumboCount + 1;
//			} else {
//				hi = jumboCount - 1;
//			}
//		}
//		return new ArrayList<>();
//	}
}
