package medium;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RangeSumOfSortedSubarraySums {
	
	public static void main(String[] args) {
		int res = rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5);
		System.out.println(res);
	}
	
	public static int rangeSum(int[] nums, int n, int left, int right) {
		final int MOD = (int) (Math.pow(10, 9) + 7);
		PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
		for (int i = 0; i < n; i++) {
			queue.offer(new Pair<>(i, nums[i]));
		}
		int res = 0;
		while (!queue.isEmpty() && right > 0) {
			Pair<Integer, Integer> pair = queue.poll();
			if (left <= 1) {
				res = (res + pair.getValue()) % MOD;
			}
			Integer index = pair.getKey();
			if (index < n - 1) {
				queue.offer(new Pair<>(index + 1, pair.getValue() + nums[index + 1]));
			}
			left--;
			right--;
		}
		return res;
	}
}
