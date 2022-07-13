package medium;

import java.util.Arrays;
import java.util.List;

public class Triangle {
	
	public static void main(String[] args) {
		int res = minimumTotal(Arrays.asList(
				Arrays.asList(-1),
				Arrays.asList(2, 3),
				Arrays.asList(1, -1, -3)
		));
		System.out.println(res);
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		for (int i = n - 2; i >= 0; i--) {
			List<Integer> row = triangle.get(i);
			List<Integer> prev = triangle.get(i + 1);
			for (int j = 0; j < row.size(); j++) {
				row.set(j, row.get(j) + Math.min(prev.get(j), prev.get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	}
//	public static int minimumTotal(List<List<Integer>> triangle) {
//		for (int i = 1; i < triangle.size(); i++) {
//			List<Integer> prev = triangle.get(i - 1);
//			List<Integer> list = triangle.get(i);
//			int n = list.size();
//			list.set(0, list.get(0) + prev.get(0));
//			for (int j = 1; j < n - 1; j++) {
//				list.set(j, list.get(j) + Math.min(prev.get(j - 1), prev.get(j)));
//			}
//			list.set(n - 1, list.get(n - 1) + prev.get(prev.size() - 1));
//		}
//		int res = Integer.MAX_VALUE;
//		for (Integer sum : triangle.get(triangle.size() - 1)) {
//			res = Math.min(res, sum);
//		}
//		return res;
//	}
}
