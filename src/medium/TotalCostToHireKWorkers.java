package medium;

import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
	
	public static void main(String[] args) {
		long res = totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4);
		System.out.println(res);
	}
	
	public static long totalCost(int[] costs, int k, int candidates) {
		long res = 0;
		int n = costs.length, left = 0, right = n - 1;
		PriorityQueue<Integer> leftQ = new PriorityQueue<>(), rightQ = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			while (leftQ.size() < candidates && left <= right) {
				leftQ.offer(costs[left++]);
			}
			while (rightQ.size() < candidates && left <= right) {
				rightQ.offer(costs[right--]);
			}
			
			int leftCost = leftQ.isEmpty() ? Integer.MAX_VALUE : leftQ.peek();
			int rightCost = rightQ.isEmpty() ? Integer.MAX_VALUE : rightQ.peek();
			if (leftCost <= rightCost) {
				res += leftQ.poll();
			} else {
				res += rightQ.poll();
			}
		}
		return res;
	}
	
}
