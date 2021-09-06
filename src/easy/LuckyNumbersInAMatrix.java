package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuckyNumbersInAMatrix {
	
	public static void main(String[] args) {
		List<Integer> res = luckyNumbers(new int[][]{
				{1, 10, 4, 2},
				{9, 3, 8, 7},
				{15, 16, 17, 12},
		});
		System.out.println(res);
	}
	
	public static List<Integer> luckyNumbers(int[][] matrix) {
		Set<Integer> mins = new HashSet<>();
		List<Integer> res = new ArrayList<>();
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				min = Math.min(min, matrix[i][j]);
			}
			mins.add(min);
		}
		
		for (int j = 0; j < n; j++) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < m; i++) {
				max = Math.max(max, matrix[i][j]);
			}
			if (mins.contains(max)) {
				res.add(max);
			}
		}
		return res;
	}
}
