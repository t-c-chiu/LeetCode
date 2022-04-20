package medium;

public class NumberOfSpacesCleaningRobotCleaned {
	
	public static void main(String[] args) {
		int res = numberOfCleanRooms(new int[][]{
				{0, 0, 0},
				{1, 1, 0},
				{0, 0, 0}
		});
		System.out.println(res);
	}
	
	public static int numberOfCleanRooms(int[][] room) {
		int m = room.length, n = room[0].length, r = 0, c = 0, d = 1, res = 0;
		int[][] dirs = new int[][]{{}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int[][] visited = new int[m][n];
		while (true) {
			if (r < 0 || c < 0 || r == m || c == n || room[r][c] == 1) {
				r -= dirs[d][0];
				c -= dirs[d][1];
				d = d % 4 + 1;
				continue;
			}
			if (visited[r][c] == d) {
				return res;
			}
			if (visited[r][c] == 0) {
				visited[r][c] = d;
				res++;
			}
			r += dirs[d][0];
			c += dirs[d][1];
		}
	}
}
