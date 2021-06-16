package medium;

public class MinimumDeletionCostToAvoidRepeatingLetters {
	
	public static void main(String[] args) {
		int res = minCost("aaabc", new int[]{2, 3, 2, 4, 5});
		System.out.println(res);
	}
	
	public static int minCost(String s, int[] cost) {
		int res = 0;
		int last = 0;
		int cur = 1;
		int n = s.length();
		while (cur < n) {
			if (s.charAt(last) == s.charAt(cur)) {
				if (cost[last] > cost[cur]) {
					res += cost[cur];
				} else {
					res += cost[last];
					last = cur;
				}
			} else {
				last = cur;
			}
			cur++;
		}
		return res;
	}
}
