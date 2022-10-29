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
			if (asteroids[i] < 0) {
				while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
					stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() == -asteroids[i]) {
					stack.pop();
				} else if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroids[i]);
				}
			} else {
				stack.push(asteroids[i]);
			}
		}
		int[] res = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}
		return res;
	}
}
