package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	public static void main(String[] args) {
		List<List<Integer>> res = combine(4, 2);
		System.out.println(res);
	}
	
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, n, k, 1, new ArrayList<>());
		return res;
	}
	
	private static void backtrack(List<List<Integer>> res, int n, int k, int start, List<Integer> temp) {
		if (temp.size() == k) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i <= n; i++) {
			temp.add(i);
			backtrack(res, n, k, i + 1, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
