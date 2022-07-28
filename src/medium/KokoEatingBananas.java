package medium;

import java.util.Arrays;

public class KokoEatingBananas {
	
	public static void main(String[] args) {
		int res = minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
		System.out.println(res);
	}
	
	public static int minEatingSpeed(int[] piles, int h) {
		int lo = 1, hi = Arrays.stream(piles).max().getAsInt();
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (canEat(piles, mid, h)) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	
	private static boolean canEat(int[] piles, int oneBite, int h) {
		int needHours = 0;
		for (int pile : piles) {
			needHours += pile / oneBite;
			if (pile % oneBite != 0) {
				needHours++;
			}
		}
		return needHours <= h;
	}
}
