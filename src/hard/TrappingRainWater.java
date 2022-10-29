package hard;

import java.util.Stack;

public class TrappingRainWater {
	
	public static void main(String[] args) {
		int res = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
		System.out.println(res);
	}
	
	public static int trap(int[] height) {
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
				Integer cur = stack.pop();
				if (!stack.isEmpty()) {
					Integer left = stack.peek();
					res += (Math.min(height[left], height[i]) - height[cur]) * (i - left - 1);
				}
			}
			stack.push(i);
		}
		return res;
	}
//	public static int trap(int[] height) {
//		int n = height.length, left = 0, right = n - 1, leftMax = height[left], rightMax = height[right], res = 0;
//		while (left <= right) {
//			if (leftMax <= rightMax) {
//				if (leftMax > height[left]) {
//					res += leftMax - height[left];
//				} else {
//					leftMax = height[left];
//				}
//				left++;
//			} else {
//				if (rightMax > height[right]) {
//					res += rightMax - height[right];
//				} else {
//					rightMax = height[right];
//				}
//				right--;
//			}
//		}
//		return res;
//	}

//	public static int trap(int[] height) {
//		int n = height.length;
//		int[] maxLeft = new int[n], maxRight = new int[n];
//		int max = 0;
//		for (int i = 0; i < n; i++) {
//			maxLeft[i] = max;
//			max = Math.max(max, height[i]);
//		}
//		max = 0;
//		for (int i = n - 1; i >= 0; i--) {
//			maxRight[i] = max;
//			max = Math.max(max, height[i]);
//		}
//		int res = 0;
//		for (int i = 1; i < n - 1; i++) {
//			res += Math.max(0, Math.min(maxLeft[i], maxRight[i]) - height[i]);
//		}
//		return res;
//	}

}
