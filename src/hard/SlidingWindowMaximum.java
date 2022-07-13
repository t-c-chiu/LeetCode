package hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
	
	public static void main(String[] args) {
		int[] res = maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[n - k + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			deque.offerLast(i);
			if (i - k + 1 >= 0) {
				res[i - k + 1] = nums[deque.peekFirst()];
			}
		}
		return res;
	}
}
