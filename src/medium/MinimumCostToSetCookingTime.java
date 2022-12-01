package medium;

public class MinimumCostToSetCookingTime {
	
	public static void main(String[] args) {
		int res = minCostSetTime(1, 2, 1, 600);
		System.out.println(res);
	}
	
	public static int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
		int min = Integer.MAX_VALUE, maxMinute = targetSeconds / 60;
		for (int minute = 0; minute <= maxMinute; minute++) {
			int second = targetSeconds - minute * 60;
			if (minute > 99 || second > 99) {
				continue;
			}
			String digit = String.valueOf(minute * 100 + second);
			int start = startAt, cost = 0;
			for (int i = 0; i < digit.length(); i++) {
				if (digit.charAt(i) - '0' == start) {
					cost += pushCost;
				} else {
					cost += moveCost + pushCost;
					start = digit.charAt(i) - '0';
				}
			}
			min = Math.min(min, cost);
		}
		return min;
	}
}
