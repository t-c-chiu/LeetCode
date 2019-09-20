package easy;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
	
	public static void main(String[] args) {
		TwoCityScheduling test = new TwoCityScheduling();
		System.out.println(test.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
	}
	
	public int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs, Comparator.comparingInt(cost -> (cost[0] - cost[1])));
		int res = 0;
		for (int i = 0; i < costs.length; i++) {
			res += costs[i][i < costs.length / 2 ? 0 : 1];
		}
		return res;
	}
}
