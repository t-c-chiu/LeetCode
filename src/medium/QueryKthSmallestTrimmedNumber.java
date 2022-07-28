package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class QueryKthSmallestTrimmedNumber {
	
	public static void main(String[] args) {
		int[] res = smallestTrimmedNumbers(new String[]{"102", "473", "251", "814"}, new int[][]{{1, 1}, {2, 3}, {4, 2}, {1, 2}});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
		int n = queries.length;
		int[] res = new int[n];
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			int k = query[0];
			int trim = query[1];
			PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> a.s.equals(b.s) ? a.i - b.i : a.s.compareTo(b.s));
			for (int j = 0; j < nums.length; j++) {
				String num = nums[j];
				num = num.substring(num.length() - trim);
				pq.offer(new Info(j, num));
			}
			while (k > 1) {
				pq.poll();
				k--;
			}
			res[i] = pq.poll().i;
		}
		return res;
	}
	
	static class Info {
		int i;
		String s;
		
		Info(int i, String s) {
			this.i = i;
			this.s = s;
		}
	}
}
