package medium;

public class RobotBoundedInCircle {
	
	public static void main(String[] args) {
		boolean res = isRobotBounded("GL");
		System.out.println(res);
	}
	
	public static boolean isRobotBounded(String instructions) {
		int i = 0, x = 0, y = 0;
		int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		for (int j = 0; j < instructions.length(); j++) {
			char c = instructions.charAt(j);
			if (c == 'R') {
				i = (i + 1) % 4;
			} else if (c == 'L') {
				i = (i + 3) % 4;
			} else {
				x += dirs[i][0];
				y += dirs[i][1];
			}
		}
		return x == 0 && y == 0 || i > 0;
	}
	
}
