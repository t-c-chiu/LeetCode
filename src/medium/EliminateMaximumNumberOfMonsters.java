package medium;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {
	
	public static void main(String[] args) {
		int res = eliminateMaximum(new int[]{4, 8, 6, 8, 2, 7, 4}, new int[]{1, 3, 3, 1, 10, 1, 1});
		System.out.println(res);
	}
	
	public static int eliminateMaximum(int[] dist, int[] speed) {
		int n = dist.length;
		double[] rate = new double[n];
		for (int i = 0; i < n; i++) {
			rate[i] = dist[i] * 1.0 / speed[i];
		}
		Arrays.sort(rate);
		
		int minute = 0;
		for (int i = 0; i < n; i++) {
			if (rate[i] <= minute) {
				break;
			}
			minute++;
		}
		return minute;
	}
}
