package hard;

import java.util.Stack;

public class TrappingRainWater {
	
	public static void main(String[] args) {
		int res = trap(new int[]{5, 2, 1, 2, 1, 5});
		System.out.println(res);
	}
	
	public static int trap(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
				int cur = stack.pop();
				if (!stack.isEmpty()) {
					int left = stack.peek();
					res += (Math.min(height[left], height[i]) - height[cur]) * (i - left - 1);
				}
			}
			stack.push(i);
		}
		return res;
	}
//	public static int trap(int[] height) {
//		Stack<Integer> stack = new Stack<>();
//		int res = 0;
//		for (int i = 0; i < height.length; i++) {
//			while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
//				int base = height[stack.pop()];
//				if (!stack.isEmpty()) {
//					res += (Math.min(height[stack.peek()], height[i]) - base) * (i - stack.peek() - 1);
//				}
//			}
//			stack.push(i);
//		}
//		return res;
//	}
	
	
}
