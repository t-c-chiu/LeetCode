package easy;

public class ClimbingStairs {
	public static void main(String[] args) {
		ClimbingStairs climbingStairs = new ClimbingStairs();
		System.out.println(climbingStairs.climbStairs(1));
		System.out.println(climbingStairs.climbStairs(2));
		System.out.println(climbingStairs.climbStairs(3));
		System.out.println(climbingStairs.climbStairs(4));
		System.out.println(climbingStairs.climbStairs(5));
	}

	public int climbStairs(int n) {
		if (n == 1)
			return 1;
		int[] step = new int[n + 1];
		step[1] = 1;
		step[2] = 2;
		for (int i = 3; i <= n; i++) {
			step[i] = step[i - 1] + step[i - 2];
		}
		return step[n];
	}
}
