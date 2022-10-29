package medium;

import java.util.*;

public class CutOffTreesForGolfEvent {
	
	public static void main(String[] args) {
		int res = cutOffTree(Arrays.asList(
				Arrays.asList(2, 3, 4),
				Arrays.asList(0, 0, 5),
				Arrays.asList(8, 7, 6)
		));
		System.out.println(res);
	}
	
	
	public static int cutOffTree(List<List<Integer>> forest) {
		int m = forest.size(), n = forest.get(0).size();
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Integer height = forest.get(i).get(j);
				if (height > 1) {
					pq.offer(new int[]{i, j, height});
				}
			}
		}
		int res = 0;
		int[] start = new int[2];
		while (!pq.isEmpty()) {
			int[] target = pq.poll();
			int steps = minStep(start, target, m, n, forest);
			if (steps == -1) {
				return steps;
			}
			res += steps;
			start = new int[]{target[0], target[1]};
		}
		return res;
	}
	
	private static int minStep(int[] start, int[] target, int m, int n, List<List<Integer>> forest) {
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		queue.offer(start);
		visited[start[0]][start[1]] = true;
		int step = 0;
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				int[] cur = queue.poll();
				if (cur[0] == target[0] && cur[1] == target[1]) {
					return step;
				}
				for (int[] dir : dirs) {
					int x = cur[0] + dir[0];
					int y = cur[1] + dir[1];
					if (x < 0 || x == m || y < 0 || y == n || visited[x][y] || forest.get(x).get(y) == 0) {
						continue;
					}
					visited[x][y] = true;
					queue.offer(new int[]{x, y});
				}
			}
			step++;
		}
		return -1;
	}
	
}
