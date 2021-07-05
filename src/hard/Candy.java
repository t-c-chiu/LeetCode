package hard;

import java.util.Arrays;

public class Candy {
	
	public static void main(String[] args) {
		int res = candy(new int[]{1, 2, 2});
		System.out.println(res);
	}
	
	public static int candy(int[] ratings) {
		int res = 0;
		int n = ratings.length;
		int[] left2Right = new int[n];
		int[] right2Left = new int[n];
		Arrays.fill(left2Right, 1);
		Arrays.fill(right2Left, 1);
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				left2Right[i] = left2Right[i - 1] + 1;
			}
			if (ratings[n - i - 1] > ratings[n - i]) {
				right2Left[n - i - 1] = right2Left[n - i] + 1;
			}
		}
		for (int i = 0; i < n; i++) {
			res += Math.max(left2Right[i], right2Left[i]);
		}
		return res;
	}
}
