package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
	
	public static void main(String[] args) {
		int res = removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}});
		System.out.println(res);
	}
	
	public static int removeStones(int[][] stones) {
		int n = stones.length, res = 0;
		Map<Integer, Set<Integer>> row = new HashMap<>();
		Map<Integer, Set<Integer>> col = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int[] stone = stones[i];
			int r = stone[0];
			int c = stone[1];
			row.putIfAbsent(r, new HashSet<>());
			row.get(r).add(i);
			col.putIfAbsent(c, new HashSet<>());
			col.get(c).add(i);
		}
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < n; i++) {
			int[] stone = stones[i];
			int r = stone[0];
			int c = stone[1];
			int p = find(parent, i);
			for (Integer neighbor : row.get(r)) {
				if (neighbor == i) {
					continue;
				}
				int np = find(parent, neighbor);
				if (p != np) {
					parent[np] = p;
					res++;
				}
			}
			for (Integer neighbor : col.get(c)) {
				if (neighbor == i) {
					continue;
				}
				int np = find(parent, neighbor);
				if (p != np) {
					parent[np] = p;
					res++;
				}
			}
		}
		return res;
	}
	
	private static int find(int[] parent, int i) {
		if (parent[i] != i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}
}
