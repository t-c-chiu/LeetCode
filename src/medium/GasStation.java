package medium;

public class GasStation {
	
	public static void main(String[] args) {
		int res = canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
		System.out.println(res);
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0, tank = 0, start = 0;
		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}
		return total < 0 ? -1 : start;
	}
}
