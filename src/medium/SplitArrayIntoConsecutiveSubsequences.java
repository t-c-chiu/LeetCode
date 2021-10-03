package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SplitArrayIntoConsecutiveSubsequences {
	
	public static void main(String[] args) {
		boolean res = isPossible(new int[]{1,2,3,4,4,5});
		System.out.println(res);
	}
	
	/**
	 * 1,2,3,3,4,5
	 * 1,2,3,3,4,4,5,5
	 * 1,2,3,4,4,5
	 */
	public static boolean isPossible(int[] nums) {
		// key = end with i, value = length of subsequences ending with i
		// it could be more than one subsequences ending with i
		// so we use PriorityQueue to increase length greedily
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int num : nums) {
			map.putIfAbsent(num, new PriorityQueue<>());
			PriorityQueue<Integer> queue = map.get(num - 1);
			if (queue == null || queue.isEmpty()) {
				map.get(num).offer(1);
			} else {
				map.get(num).offer(queue.poll() + 1);
			}
		}
		for (PriorityQueue<Integer> queue : map.values()) {
			while (!queue.isEmpty()) {
				if (queue.poll() < 3) {
					return false;
				}
			}
		}
		return true;
	}
}
