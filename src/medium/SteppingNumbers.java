package medium;

import java.util.*;

public class SteppingNumbers {
	
	public static void main(String[] args) {
		List<Integer> res = countSteppingNumbers(0, 21);
		System.out.println(res);
	}
	
	public static List<Integer> countSteppingNumbers(int low, int high) {
		List<Integer> res = new ArrayList<>();
		if (low == 0) {
			res.add(0);
		}
		
		Queue<Long> queue = new LinkedList<>();
		for (long i = 1; i <= 9; i++) {
			queue.offer(i);
		}
		while (!queue.isEmpty()) {
			long num = queue.poll();
			if (num > high) {
				break;
			}
			if (num >= low) {
				res.add((int) num);
			}
			
			long lastDigit = num % 10;
			num *= 10;
			if (lastDigit > 0) {
				queue.add(num + lastDigit - 1);
			}
			if (lastDigit < 9) {
				queue.add(num + lastDigit + 1);
			}
		}
		return res;
	}
	
}
