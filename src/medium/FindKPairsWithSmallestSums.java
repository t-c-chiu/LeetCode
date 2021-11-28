package medium;

import java.util.*;

public class FindKPairsWithSmallestSums {
	
	public static void main(String[] args) {
		List<List<Integer>> res = kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10);
		System.out.println(res);
	}
	
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> (nums1[o[0]] + nums2[o[1]])));
		for (int i = 0; i < nums1.length && i < k; i++) {
			pq.offer(new int[]{i, 0});
		}
		while (!pq.isEmpty() && res.size() < k) {
			int[] poll = pq.poll();
			int i = poll[0], j = poll[1];
			res.add(Arrays.asList(nums1[i], nums2[j]));
			if (j < nums2.length - 1) {
				pq.offer(new int[]{i, j + 1});
			}
		}
		return res;
	}
}
