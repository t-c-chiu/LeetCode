package medium;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
	
	public static void main(String[] args) {
		int[] res = asteroidCollision(new int[]{-2, -2, 1, -2});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < asteroids.length; i++) {
			int num = asteroids[i];
			if (num > 0) {
				stack.push(num);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {
					stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() == -num) {
					stack.pop();
				} else if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(num);
				}
			}
		}
		int[] res = new int[stack.size()];
		int i = 0;
		for (Integer num : stack) {
			res[i++] = num;
		}
		return res;
	}
}
