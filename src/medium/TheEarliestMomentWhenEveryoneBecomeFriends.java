package medium;

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
	
	public static void main(String[] args) {
		int res = earliestAcq(new int[][]{{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}}
				, 6);
		System.out.println(res);
	}
	
	/**
	 * 0 1 2 3 - 4
	 * 02 1 3 - 3
	 * 012 3 - 2
	 * 0123 - 1
	 */
	public static int earliestAcq(int[][] logs, int n) {
		Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for (int[] log : logs) {
			int p1 = findParent(parent, log[1]);
			int p2 = findParent(parent, log[2]);
			if (p1 != p2) {
				parent[p2] = p1;
				n--;
				if (n == 1) {
					return log[0];
				}
			}
		}
		return -1;
	}
	
	private static int findParent(int[] parent, int i) {
		if (parent[i] == i) {
			return i;
		}
		int p = findParent(parent, parent[i]);
		parent[i] = p;
		return p;
	}
}
