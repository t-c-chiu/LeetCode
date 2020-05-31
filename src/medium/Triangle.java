package medium;

import java.util.Arrays;
import java.util.List;

public class Triangle {
	
	public static void main(String[] args) {
		Triangle test = new Triangle();
		final int ans = test.minimumTotal(Arrays.asList(
				Arrays.asList(-1),
				Arrays.asList(2, 3),
				Arrays.asList(1, -1, -3)
		));
		System.out.println(ans);
	}
	
	//    0
	//   0 1
	//  0 1 2
	// 0 1 2 3
	// 用DP解, 存從下到上經過該位置最小的路徑
	public int minimumTotal(List<List<Integer>> triangle) {
		final int size = triangle.size();
		Integer[] dp = triangle.get(size - 1).toArray(new Integer[]{});
		for (int i = size - 2; i >= 0; i--) {
			final List<Integer> row = triangle.get(i);
			for (int j = 0; j < row.size(); j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
			}
		}
		return dp[0];
	}
}
