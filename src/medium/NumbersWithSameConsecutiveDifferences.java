package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
	
	public static void main(String[] args) {
		int[] res = numsSameConsecDiff(2, 0);
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] numsSameConsecDiff(int n, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			backtrack(list, n - 1, k, i);
		}
		return list.stream().mapToInt(i -> i).toArray();
	}
	
	private static void backtrack(List<Integer> list, int n, int k, int num) {
		if (n == 0) {
			list.add(num);
			return;
		}
		int lastDigit = num % 10;
		if (lastDigit - k >= 0) {
			backtrack(list, n - 1, k, num * 10 + lastDigit - k);
		}
		if (k > 0 && lastDigit + k <= 9) {
			backtrack(list, n - 1, k, num * 10 + lastDigit + k);
		}
	}
}
