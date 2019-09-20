package easy;

import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations {
	
	public static void main(String[] args) {
		MaximizeSumOfArrayAfterKNegations test = new MaximizeSumOfArrayAfterKNegations();
		System.out.println(test.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
		System.out.println(test.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
		System.out.println(test.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
	}
	
	public int largestSumAfterKNegations(int[] A, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i : A) {
			queue.add(i);
		}
		for (int i = 0; i < K; i++) {
			queue.add(-queue.poll());
		}
		int res = 0;
		for (Integer i : queue) {
			res += i;
		}
		return res;
	}
}
