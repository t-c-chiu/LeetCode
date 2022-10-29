package easy;

public class TheEmployeeThatWorkedOnTheLongestTask {
	
	public static void main(String[] args) {
		int res = hardestWorker(10, new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}});
		System.out.println(res);
	}
	
	public static int hardestWorker(int n, int[][] logs) {
		int res = logs[0][0], max = logs[0][1];
		for (int i = 1; i < logs.length; i++) {
			int duration = logs[i][1] - logs[i - 1][1];
			if (duration > max || duration == max && logs[i][0] < res) {
				res = logs[i][0];
				max = duration;
			}
		}
		return res;
	}
}
