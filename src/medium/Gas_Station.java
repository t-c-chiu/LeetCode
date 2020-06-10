package medium;

public class Gas_Station {
	
	public static void main(String[] args) {
		Gas_Station test = new Gas_Station();
		int res = test.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
		System.out.println(res);
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int tank = 0, start = 0, total = 0;
		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			if (tank < 0) {
				total += tank;
				start = i + 1;
				tank = 0;
			}
		}
		return total + tank < 0 ? -1 : start;
	}
}
