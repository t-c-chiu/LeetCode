package medium;

import java.util.*;

public class JumpGameVI {
	
	public static void main(String[] args) {
		int res = maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2);
		System.out.println(res);
	}
	
	public static int maxResult(int[] nums, int k) {
		int n = nums.length;
		Deque<Integer> deque = new LinkedList<>();
		deque.offer(0);
		for (int i = 1; i < n; i++) {
			nums[i] += nums[deque.peekFirst()];
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.offerLast(i);
			if (deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
		}
		return nums[n - 1];
	}
//	public static int maxResult(int[] nums, int k) {
//		int n = nums.length;
//		if (n == 1) {
//			return nums[0];
//		}
//
//		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
//		queue.offer(new int[]{nums[0], 0});
//		for (int i = 1; i < n - 1; i++) {
//			queue.offer(new int[]{queue.peek()[0] + nums[i], i});
//			while (queue.peek()[1] <= i - k) {
//				queue.poll();
//			}
//		}
//		return queue.peek()[0] + nums[n - 1];
//	}
}
