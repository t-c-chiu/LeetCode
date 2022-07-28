package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	
	public static void main(String[] args) {
		List<List<Integer>> res = generate(5);
		System.out.println(res);
	}
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(Arrays.asList(1));
		for (int i = 2; i <= numRows; i++) {
			List<Integer> last = res.get(res.size() - 1);
			List<Integer> cur = new ArrayList<>();
			cur.add(last.get(0));
			for (int j = 1; j < last.size(); j++) {
				cur.add(last.get(j - 1) + last.get(j));
			}
			cur.add(last.get(last.size() - 1));
			res.add(cur);
		}
		return res;
	}
}
