package medium;

public class MaximumCompatibilityScoreSum {
	
	public static void main(String[] args) {
		int res = maxCompatibilitySum(
				new int[][]{{0, 0}, {0, 0}, {0, 0}},
				new int[][]{{1, 1}, {1, 1}, {1, 1}});
		System.out.println(res);
	}
	
	static int max = 0;
	
	/**
	 * 2 0 3
	 * 2 2 1
	 * 1 3 0
	 */
	public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
		int n = students.length;
		int m = students[0].length;
		int[][] match = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (students[i][k] == mentors[j][k]) {
						match[i][j]++;
					}
				}
			}
		}
		
		dfs(match, 0, 0, new boolean[n]);
		return max;
		
	}
	
	private static void dfs(int[][] match, int i, int sum, boolean[] visited) {
		int n = match.length;
		int m = match[0].length;
		if (i == n) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int j = 0; j < m; j++) {
			if (visited[j]) {
				continue;
			}
			
			visited[j] = true;
			sum += match[i][j];
			dfs(match, i + 1, sum, visited);
			sum -= match[i][j];
			visited[j] = false;
		}
	}
}
