package easy;

public class Divisor_Game {
	
	public static void main(String[] args) {
		Divisor_Game test = new Divisor_Game();
		System.out.println(test.divisorGame(2));
		System.out.println(test.divisorGame(5));
		System.out.println(test.divisorGame(6));
		System.out.println(test.divisorGame(7));
	}
	
	public boolean divisorGame(int N) {
		if (N < 2)
			return false;
		boolean[] dp = new boolean[N + 1];
		dp[2] = true;
		for (int i = 3; i <= N; i++) {
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0 && !dp[i - j]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[N];
	}
}
