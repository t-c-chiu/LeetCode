package medium;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {
	
	public static void main(String[] args) {
		int res = carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3});
		System.out.println(res);
	}
	
	public static int carFleet(int target, int[] position, int[] speed) {
		int n = position.length;
		double[][] cars = new double[n][2];
		for (int i = 0; i < n; i++) {
			cars[i] = new double[]{position[i], (double) (target - position[i]) / speed[i]};
		}
		Arrays.sort(cars, Comparator.comparingDouble(o -> -o[0]));
		double time = 0;
		int fleet = 0;
		for (double[] car : cars) {
			if (car[1] > time) {
				fleet++;
				time = car[1];
			}
		}
		return fleet;
	}
	
}
