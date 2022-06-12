package medium;

public class JumpGameVII {
	
	public static void main(String[] args) {
		boolean res = canReach("011010", 2, 3);
		System.out.println(res);
	}
	
	public static boolean canReach(String s, int minJump, int maxJump) {
		int n = s.length(), count = 0;
		boolean[] dp = new boolean[n];
		dp[0] = true;
		for (int i = 1; i < n; i++) {
			if (i >= minJump && dp[i - minJump]) {
				count++;
			}
			if (i > maxJump && dp[i - maxJump - 1]) {
				count--;
			}
			dp[i] = count > 0 && s.charAt(i) == '0';
		}
		return dp[n - 1];
	}

//	public static boolean canReach(String s, int minJump, int maxJump) {
//		int n = s.length();
//		if (s.charAt(n - 1) != '0') {
//			return false;
//		}
//
//		Queue<Integer> queue = new LinkedList<>();
//		queue.offer(0);
//		int maxReach = 0;
//		while (!queue.isEmpty()) {
//			int start = queue.poll();
//			if (start == n - 1) {
//				return true;
//			}
//			for (int i = Math.max(start + minJump, maxReach); i <= Math.min(start + maxJump, n - 1); i++) {
//				if (s.charAt(i) == '0') {
//					queue.offer(i);
//				}
//			}
//			maxReach = Math.min(start + maxJump + 1, n - 1);
//		}
//		return false;
//	}
}
