package medium;

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
	
	public static void main(String[] args) {
		int res = earliestAcq(new int[][]{{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}}
				, 6);
		System.out.println(res);
	}
	
	public static int earliestAcq(int[][] logs, int n) {
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));
		for (int[] log : logs) {
			int timestamp = log[0];
			int a = log[1];
			int b = log[2];
			int p1 = find(parent, a);
			int p2 = find(parent, b);
			if (p1 != p2) {
				parent[p1] = p2;
				n--;
			}
			if (n == 1) {
				return timestamp;
			}
		}
		return -1;
	}
	
	private static int find(int[] parent, int i) {
		if (parent[i] != i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}
	
}
