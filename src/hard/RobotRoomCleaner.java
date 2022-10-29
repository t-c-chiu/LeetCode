package hard;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
	
	int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public void cleanRoom(Robot robot) {
		clean(robot, new HashSet<>(), 0, 0, 0);
	}
	
	private void clean(Robot robot, Set<String> seen, int x, int y, int dir) {
		robot.clean();
		seen.add(x + "," + y);
		for (int i = 0; i < 4; i++) {
			int nextDir = (dir + i) % 4;
			int nextX = x + dirs[nextDir][0];
			int nextY = y + dirs[nextDir][1];
			if (!seen.contains(nextX + "," + nextY) && robot.move()) {
				clean(robot, seen, nextX, nextY, nextDir);
			}
			robot.turnRight();
		}
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}
	
	// This is the robot's control interface.
	// You should not implement it, or speculate about its implementation
	interface Robot {
		// Returns true if the cell in front is open and robot moves into the cell.
		// Returns false if the cell in front is blocked and robot stays in the current cell.
		public boolean move();
		
		// Robot will stay in the same cell after calling turnLeft/turnRight.
		// Each turn will be 90 degrees.
		public void turnLeft();
		
		public void turnRight();
		
		// Clean the current cell.
		public void clean();
	}
}
