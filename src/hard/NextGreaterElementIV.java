package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class NextGreaterElementIV {
	
	public static void main(String[] args) {
		int[] res = secondGreaterElement(new int[]{2, 4, 0, 9, 6});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] secondGreaterElement(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		PriorityQueue<Integer> candidates = new PriorityQueue<>(Comparator.comparingInt(i -> nums[i]));
		int n = nums.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			// a candidate found a greater element again
			while (!candidates.isEmpty() && num > nums[candidates.peek()]) {
				res[candidates.poll()] = num;
			}
			// found first greater element, select it as a candidate
			while (!stack.isEmpty() && num > nums[stack.peek()]) {
				candidates.offer(stack.pop());
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			res[stack.pop()] = -1;
		}
		while (!candidates.isEmpty()) {
			res[candidates.poll()] = -1;
		}
		return res;
	}
}
