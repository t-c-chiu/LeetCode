package medium;

public class NumberOfProvinces {
	
	public int findCircleNum(int[][] isConnected) {
		int count = 0;
		boolean[] visited = new boolean[isConnected.length];
		for (int i = 0; i < isConnected.length; i++) {
			if (!visited[i]) {
				count++;
				dfs(isConnected, visited, i);
			}
		}
		return count;
	}
	
	public static void dfs(int[][] isConnected, boolean[] visited, int i) {
		for (int j = 0; j < isConnected.length; j++) {
			if (isConnected[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(isConnected, visited, j);
			}
		}
	}
}
