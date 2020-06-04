package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	public static void main(String[] args) {
		Combinations test = new Combinations();
		List<List<Integer>> res = test.combine(4, 2);
		System.out.println(res);
	}
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		combine(res, new ArrayList<>(), n, k, 1);
		return res;
	}
	
	private void combine(List<List<Integer>> res, List<Integer> temp, int n, int k, int start) {
		if (temp.size() == k) {
			res.add(new ArrayList<>(temp));
			return;
		}
		
		for (int i = start; i <= n; i++) {
			temp.add(i);
			combine(res, temp, n, k, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
