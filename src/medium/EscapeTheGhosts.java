package medium;

public class EscapeTheGhosts {
	
	public static void main(String[] args) {
		boolean res = escapeGhosts(new int[][]{{1, 0}, {0, 3}}, new int[]{0, 1});
		System.out.println(res);
	}
	
	public static boolean escapeGhosts(int[][] ghosts, int[] target) {
		int d = Math.abs(target[0]) + Math.abs(target[1]);
		for (int[] ghost : ghosts) {
			if (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= d) {
				return false;
			}
		}
		return true;
	}
}
