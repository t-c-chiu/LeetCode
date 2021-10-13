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
		if (n == 1) {
			return 1;
		}
		int prev = 1;
		int cur = 2;
		for (int i = 3; i <= n; i++) {
			int temp = cur;
			cur += prev;
			prev = temp;
		}
		return cur;
	}
}
