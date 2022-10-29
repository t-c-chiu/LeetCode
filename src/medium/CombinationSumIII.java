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
		helper(res, 1, k, n, new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, int start, int k, int n, List<Integer> temp) {
		if (temp.size() > k || n < 0) {
			return;
		}
		if (temp.size() == k && n == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i <= 9; i++) {
			temp.add(i);
			helper(res, i + 1, k, n - i, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
