package medium;

public class MaximumScoreFromRemovingStones {
	
	public static void main(String[] args) {
		int res = maximumScore(6, 2, 1);
		System.out.println(res);
	}
	
	public static int maximumScore(int a, int b, int c) {
		int sum = a + b + c;
		return Math.min(sum / 2, sum - Math.max(a, Math.max(b, c)));
	}
}
