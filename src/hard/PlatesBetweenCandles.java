package hard;

import java.util.Arrays;

public class PlatesBetweenCandles {
	
	public static void main(String[] args) {
		int[] res = platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] platesBetweenCandles(String s, int[][] queries) {
		int n = s.length();
		int[] nearestLeftCandle = new int[n];
		int[] nearestRightCandle = new int[n];
		int[] preSum = new int[n];
		int sum = 0;
		int last = -1;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '|') {
				last = i;
				preSum[i] = sum;
			} else {
				sum++;
			}
			nearestLeftCandle[i] = last;
		}
		last = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '|') {
				last = i;
			}
			nearestRightCandle[i] = last;
		}
		int m = queries.length;
		int[] res = new int[m];
		for (int i = 0; i < m; i++) {
			int[] query = queries[i];
			int leftCandle = nearestRightCandle[query[0]];
			int rightCandle = nearestLeftCandle[query[1]];
			if (leftCandle == -1 || rightCandle == -1 || leftCandle > rightCandle) {
				res[i] = 0;
			} else {
				res[i] = preSum[rightCandle] - preSum[leftCandle];
			}
		}
		return res;
	}
//	public static int[] platesBetweenCandles(String s, int[][] queries) {
//		int n = s.length(), sum = 0;
//		int[] preSum = new int[n];
//		TreeSet<Integer> set = new TreeSet<>();
//		for (int i = 0; i < n; i++) {
//			if (s.charAt(i) == '*') {
//				sum++;
//			} else {
//				preSum[i] = sum;
//				set.add(i);
//			}
//		}
//		int m = queries.length;
//		int[] res = new int[m];
//		for (int i = 0; i < m; i++) {
//			int[] query = queries[i];
//			Integer l = query[0], r = query[1];
//			l = set.ceiling(l);
//			r = set.floor(r);
//			if (l == null || r == null || l > r) {
//				res[i] = 0;
//			} else {
//				res[i] = preSum[r] - preSum[l];
//			}
//		}
//		return res;
//	}
}
