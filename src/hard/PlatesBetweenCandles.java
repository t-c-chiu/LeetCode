package hard;

import java.util.Arrays;

public class PlatesBetweenCandles {
	
	public static void main(String[] args) {
		int[] res = platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] platesBetweenCandles(String s, int[][] queries) {
		int n = s.length(), sum = 0;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] preSum = new int[n];
		int last = -1;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '|') {
				preSum[i] = sum;
				last = i;
			} else {
				sum++;
			}
			left[i] = last;
		}
		last = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '|') {
				last = i;
			}
			right[i] = last;
		}
		int m = queries.length;
		int[] res = new int[m];
		for (int i = 0; i < m; i++) {
			int[] query = queries[i];
			int leftCandle = right[query[0]];
			int rightCandle = left[query[1]];
			if (leftCandle == -1 || rightCandle == -1 || leftCandle > rightCandle) {
				res[i] = 0;
			} else {
				res[i] = preSum[rightCandle] - preSum[leftCandle];
			}
		}
		return res;
	}
}
