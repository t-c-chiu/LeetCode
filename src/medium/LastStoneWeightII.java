package medium;

public class LastStoneWeightII {
	
	public static void main(String[] args) {
		int res = lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
		System.out.println(res);
	}
	
	public static int lastStoneWeightII(int[] stones) {
		int sum = 0;
		for (int stone : stones) {
			sum += stone;
		}
		int half = sum / 2;
		boolean[] dp = new boolean[half + 1];
		dp[0] = true;
		for (int stone : stones) {
			for (int i = half; i >= 0; i--) {
				if (dp[i] && i + stone <= half) {
					dp[i + stone] = true;
				}
			}
		}
		for (int i = half; i >= 0; i--) {
			if (dp[i]) {
				return sum - i - i;
			}
		}
		return 0;
	}
}
