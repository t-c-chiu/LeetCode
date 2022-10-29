package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthSmallestPairDistance {
	
	public static void main(String[] args) {
		int res = smallestDistancePair(new int[]{1, 6, 1}, 3);
		System.out.println(res);
	}
	
	public static int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> nums[o[1]] - nums[o[0]]));
		for (int i = 1; i < n; i++) {
			pq.offer(new int[]{i - 1, i});
		}
		while (k > 1) {
			int[] poll = pq.poll();
			int right = poll[1];
			if (right + 1 < n) {
				pq.offer(new int[]{poll[0], right + 1});
			}
			k--;
		}
		return nums[pq.peek()[1]] - nums[pq.peek()[0]];
	}
}
