package medium;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
	
	public static void main(String[] args) {
		Combination_Sum_III test = new Combination_Sum_III();
		List<List<Integer>> res = test.combinationSum3(3, 9);
		System.out.println(res);
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		combinationSum3(res, new ArrayList<>(), k, n, 1);
		return res;
	}
	
	private void combinationSum3(List<List<Integer>> res, List<Integer> temp, int k, int n, int start) {
		if (temp.size() == k) {
			if (n == 0) {
				res.add(new ArrayList<>(temp));
			}
			return;
		}
		
		for (int i = start; i <= 9; i++) {
			temp.add(i);
			combinationSum3(res, temp, k, n - i, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
