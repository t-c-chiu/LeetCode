package easy;

public class ClimbingStairs {
	public static void main(String[] args) {
		int res = climbStairs(5);
		System.out.println(res);
	}
	
	public static int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int prev = 1, cur = 2;
		while (n > 2) {
			int next = prev + cur;
			prev = cur;
			cur = next;
			n--;
		}
		return cur;
	}
}
