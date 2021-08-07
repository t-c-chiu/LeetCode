package medium;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {
	
	public static void main(String[] args) {
		int res = maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4});
		System.out.println(res);
	}
	
	public static int maxCoins(int[] piles) {
		Arrays.sort(piles);
		int n = piles.length;
		int res = 0;
		for (int i = n / 3; i < n; i += 2) {
			res += piles[i];
		}
		return res;
	}

//	public static int maxCoins(int[] piles) {
//		Arrays.sort(piles);
//		int coin = piles.length / 3;
//		int i = piles.length - 2;
//		int res = 0;
//		while (coin > 0) {
//			res += piles[i];
//			i -= 2;
//			coin--;
//		}
//		return res;
//	}
}
