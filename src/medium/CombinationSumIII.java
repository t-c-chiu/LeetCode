package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public static void main(String[] args) {
		List<List<Integer>> res = combinationSum3(3, 9);
		System.out.println(res);
	}
	
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), k, n, 1);
		return res;
	}
	
	private static void backtrack(List<List<Integer>> res, List<Integer> temp, int k, int n, int start) {
		if (temp.size() == k && n == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i <= 9; i++) {
			if (n - i < 0) {
				return;
			}
			temp.add(i);
			backtrack(res, temp, k, n - i, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
