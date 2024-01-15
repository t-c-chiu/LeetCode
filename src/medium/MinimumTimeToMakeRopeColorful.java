package medium;

public class MinimumTimeToMakeRopeColorful {
	
	public static void main(String[] args) {
		int res = minCost("abaac", new int[]{1, 2, 3, 4, 5});
		System.out.println(res);
	}
	
	public static int minCost(String colors, int[] neededTime) {
		int res = 0, last = 0, cur = 1;
		while (cur < colors.length()) {
			if (colors.charAt(last) == colors.charAt(cur)) {
				if (neededTime[last] < neededTime[cur]) {
					res += neededTime[last];
					last = cur;
				} else {
					res += neededTime[cur];
				}
			} else {
				last = cur;
			}
			cur++;
		}
		return res;
	}
}
