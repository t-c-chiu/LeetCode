package medium;

import java.util.*;

public class FindKPairsWithSmallestSums {
	
	public static void main(String[] args) {
		List<List<Integer>> res = kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10);
		System.out.println(res);
	}
	
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> nums1[o[0]] + nums2[o[1]]));
		for (int i = 0; i < nums1.length && i < k; i++) {
			queue.offer(new int[]{i, 0});
		}
		List<List<Integer>> res = new ArrayList<>();
		while (!queue.isEmpty() && res.size() < k) {
			int[] poll = queue.poll();
			int i = poll[0];
			int j = poll[1];
			res.add(Arrays.asList(nums1[i], nums2[j]));
			if (j < nums2.length - 1) {
				queue.offer(new int[]{i, j + 1});
			}
		}
		return res;
	}
}
