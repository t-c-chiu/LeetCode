package medium;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
	
	public static void main(String[] args) {
		List<Integer> res = splitIntoFibonacci("1101111");
		System.out.println(res);
	}
	
	public static List<Integer> splitIntoFibonacci(String num) {
		List<Integer> res = new ArrayList<>();
		backtrack(res, num, 0);
		return res;
	}
	
	private static boolean backtrack(List<Integer> res, String num, int start) {
		int n = num.length(), size = res.size();
		if (size >= 3 && start == n) {
			return true;
		}
		int cur = 0;
		for (int i = start; i < n; i++) {
			if (num.charAt(start) == '0' && i > start) {
				break;
			}
			cur = cur * 10 + num.charAt(i) - '0';
			if (size >= 2 && res.get(size - 2) + res.get(size - 1) < cur) {
				break;
			}
			if (size < 2 || res.get(size - 2) + res.get(size - 1) == cur) {
				res.add(cur);
				if (backtrack(res, num, i + 1)) {
					return true;
				}
				res.remove(res.size() - 1);
			}
		}
		return false;
	}
}
