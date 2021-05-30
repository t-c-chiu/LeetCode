package medium;

import java.util.Stack;

public class FindTheMostCompetitiveSubsequence {
	
	public static void main(String[] args) {
		int[] res = mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] mostCompetitive(int[] nums, int k) {
		int[] res = new int[k];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && stack.peek() > nums[i] && nums.length - i > k - stack.size()) {
				stack.pop();
			}
			if (stack.size() < k) {
				stack.push(nums[i]);
			}
		}
		
		for (int i = k - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}
		return res;
	}
}
