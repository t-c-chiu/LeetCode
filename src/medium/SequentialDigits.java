package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SequentialDigits {
	
	public static void main(String[] args) {
		List<Integer> res = sequentialDigits(1000, 13000);
		System.out.println(res);
	}
	
	public static List<Integer> sequentialDigits(int low, int high) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			helper(low, high, 0, i, res);
		}
		res.sort(Comparator.naturalOrder());
		return res;
	}
	
	private static void helper(int low, int high, int num, int i, List<Integer> res) {
		if (num > high || i > 10) {
			return;
		}
		if (num >= low) {
			res.add(num);
		}
		helper(low, high, num * 10 + i, i + 1, res);
	}
}
