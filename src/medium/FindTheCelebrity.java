package medium;

public class FindTheCelebrity {
	
	public static void main(String[] args) {
		int res = new Solution().findCelebrity(3);
		System.out.println(res);
	}
	
	private static class Relation {
		boolean knows(int a, int b) {
			int[][] graph = new int[][]{{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
			return graph[a][b] == 1;
		}
	}
	
	public static class Solution extends Relation {
		public int findCelebrity(int n) {
			int candidate = 0;
			for (int i = 1; i < n; i++) {
				if (knows(candidate, i)) {
					candidate = i;
				}
			}
			for (int i = 0; i < n; i++) {
				if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
					return -1;
				}
			}
			return candidate;
		}
	}
	
	
}
