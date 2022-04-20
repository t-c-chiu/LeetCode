package medium;

public class AverageWaitingTime {
	
	public static void main(String[] args) {
		double res = averageWaitingTime(new int[][]{{5, 2}, {5, 4}, {10, 3}, {20, 1}});
		System.out.println(res);
	}
	
	public static double averageWaitingTime(int[][] customers) {
		int currentTime = 0;
		double waitingTime = 0;
		for (int[] customer : customers) {
			int arrival = customer[0];
			int time = customer[1];
			currentTime = Math.max(arrival, currentTime) + time;
			waitingTime += currentTime - arrival;
		}
		return waitingTime / customers.length;
	}
}
