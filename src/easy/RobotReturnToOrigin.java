package easy;

public class RobotReturnToOrigin {

	public static void main(String[] args) {
		RobotReturnToOrigin robotReturnToOrigin= new RobotReturnToOrigin();
		System.out.println(robotReturnToOrigin.judgeCircle("UD"));
		System.out.println(robotReturnToOrigin.judgeCircle("LL"));
		System.out.println(robotReturnToOrigin.judgeCircle("LLRR"));
	}

	public boolean judgeCircle(String moves) {
		int top = 0;
		int left = 0;
		for (char c : moves.toCharArray()) {
			switch (c) {
				case 'U':
					top++;
					break;
				case 'D':
					top--;
					break;
				case 'L':
					left--;
					break;
				case 'R':
					left++;
			}
		}
		return top == 0 && left == 0;
	}
}
