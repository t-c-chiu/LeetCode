package medium;

public class RobotBoundedInCircle {
	
	public static void main(String[] args) {
		boolean res = isRobotBounded("GL");
		System.out.println(res);
	}
	
	public static boolean isRobotBounded(String instructions) {
		Direction direction = new Direction(Direction.NORTH);
		int[] xy = new int[2];
		for (int i = 0; i < instructions.length(); i++) {
			char c = instructions.charAt(i);
			if (c == 'G') {
				switch (direction.cur) {
					case Direction.NORTH:
						xy[0] -= 1;
						break;
					case Direction.SOUTH:
						xy[0] += 1;
						break;
					case Direction.WEST:
						xy[1] += 1;
						break;
					case Direction.EAST:
						xy[1] -= 1;
						break;
				}
			} else if (c == 'L') {
				direction.turnLeft();
			} else {
				direction.turnRight();
			}
		}
		return !direction.cur.equals(Direction.NORTH) || xy[0] == 0 && xy[1] == 0;
	}
	
	static class Direction {
		private static final String EAST = "EAST";
		private static final String WEST = "WEST";
		private static final String NORTH = "NORTH";
		private static final String SOUTH = "SOUTH";
		
		private String cur;
		
		Direction(String cur) {
			this.cur = cur;
		}
		
		void turnLeft() {
			switch (cur) {
				case EAST:
					cur = NORTH;
					return;
				case WEST:
					cur = SOUTH;
					return;
				case NORTH:
					cur = WEST;
					return;
				case SOUTH:
					cur = EAST;
				
			}
		}
		
		void turnRight() {
			switch (cur) {
				case EAST:
					cur = SOUTH;
					return;
				case WEST:
					cur = NORTH;
					return;
				case NORTH:
					cur = EAST;
					return;
				case SOUTH:
					cur = WEST;
			}
		}
	}
}
