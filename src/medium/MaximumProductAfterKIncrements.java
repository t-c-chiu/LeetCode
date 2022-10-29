package medium;

import java.util.PriorityQueue;

public class MaximumProductAfterKIncrements {
	
	public static void main(String[] args) {
		int res = maximumProduct(new int[]{6, 3, 3, 2}, 2);
		System.out.println(res);
	}
	
	public static int maximumProduct(int[] nums, int k) {
		int mod = (int) (1e9 + 7);
		if (nums.length == 1) {
			return (nums[0] + k) % mod;
		}
		long product = 1;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int num : nums) {
			pq.offer((long) num);
		}
		while (k > 0) {
			long num1 = pq.poll();
			long num2 = pq.poll();
			long diff = Math.min(k, num2 - num1 + 1);
			k -= diff;
			num1 += diff;
			pq.offer(num1);
			pq.offer(num2);
		}
		while (!pq.isEmpty()) {
			product = (product * pq.poll()) % mod;
		}
		return (int) (product % mod);
	}
}

