package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
	
	public static void main(String[] args) {
		double res = maxAverageRatio(new int[][]{
				{1, 2},
				{3, 5},
				{2, 2},
		}, 2);
		System.out.println(res);
	}
	
	public static double maxAverageRatio(int[][] classes, int extraStudents) {
		PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> -o[0]));
		for (int[] clazz : classes) {
			pq.offer(new double[]{profit(clazz[0], clazz[1]), clazz[0], clazz[1]});
		}
		
		for (int i = 0; i < extraStudents; i++) {
			double[] info = pq.poll();
			info[0] = profit(++info[1], ++info[2]);
			pq.offer(info);
		}
		
		double res = 0;
		while (!pq.isEmpty()) {
			double[] info = pq.poll();
			res += info[1] / info[2];
		}
		return res / classes.length;
	}
	
	private static double profit(double pass, double total) {
		return (pass + 1) / (total + 1) - pass / total;
	}
}
