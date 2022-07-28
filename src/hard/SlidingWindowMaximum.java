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
		Deque<Integer> dq = new ArrayDeque<>();
		for (int r = 0; r < n; r++) {
			if (!dq.isEmpty() && dq.peekFirst() <= r - k) {
				dq.pollFirst();
			}
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
				dq.pollLast();
			}
			dq.offerLast(r);
			if (r - k + 1 >= 0) {
				res[r - k + 1] = nums[dq.peekFirst()];
			}
		}
		return res;
	}
}
