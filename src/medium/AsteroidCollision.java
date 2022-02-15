package medium;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
	
	public static void main(String[] args) {
		int[] res = asteroidCollision(new int[]{-2,-2,1,-2});
		Arrays.stream(res).forEach(System.out::println);
	}
	
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int asteroid : asteroids) {
			if (stack.isEmpty() || stack.peek() < 0 || asteroid > 0) {
				stack.add(asteroid);
				continue;
			}
			
			while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
				stack.pop();
			}
			if (stack.isEmpty() || stack.peek() < 0) {
				stack.push(asteroid);
			} else if (stack.peek() == -asteroid) {
				stack.pop();
			}
		}
		int[] res = new int[stack.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = stack.get(i);
		}
		return res;
	}
}
