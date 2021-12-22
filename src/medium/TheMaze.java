package medium;

public class TheMaze {
	
	public static void main(String[] args) {
		boolean res = hasPath(new int[][]{
						{0, 0, 1, 0, 0},
						{0, 0, 0, 0, 0},
						{0, 0, 0, 1, 0},
						{1, 1, 0, 1, 1},
						{0, 0, 0, 0, 0}},
				new int[]{0, 4},
				new int[]{3, 2}
		);
		System.out.println(res);
	}
	
	public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
		return dfs(maze, start, destination, new boolean[maze.length][maze[0].length]);
	}
	
	private static boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
		int i = start[0], j = start[1];
		if (visited[i][j]) {
			return false;
		}
		if (i == destination[0] && j == destination[1]) {
			return true;
		}
		visited[i][j] = true;
		
		int u = i - 1, d = i + 1, l = j - 1, r = j + 1;
		while (u >= 0 && maze[u][j] == 0) {
			u--;
		}
		if (dfs(maze, new int[]{u + 1, j}, destination, visited)) {
			return true;
		}
		while (d < maze.length && maze[d][j] == 0) {
			d++;
		}
		if (dfs(maze, new int[]{d - 1, j}, destination, visited)) {
			return true;
		}
		while (l >= 0 && maze[i][l] == 0) {
			l--;
		}
		if (dfs(maze, new int[]{i, l + 1}, destination, visited)) {
			return true;
		}
		while (r < maze[0].length && maze[i][r] == 0) {
			r++;
		}
		if (dfs(maze, new int[]{i, r - 1}, destination, visited)) {
			return true;
		}
		return false;
	}
	
}
