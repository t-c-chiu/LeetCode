package medium;

public class CapacityToShipPackagesWithinDDays {
	
	public static void main(String[] args) {
		int res = shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
		System.out.println(res);
	}
	
	public static int shipWithinDays(int[] weights, int days) {
		int left = 0, right = 0;
		for (int weight : weights) {
			left = Math.max(left, weight);
			right += weight;
		}
		while (left < right) {
			int mid = (left + right) / 2, bags = 1, sum = 0;
			for (int weight : weights) {
				if (sum + weight > mid) {
					bags++;
					sum = 0;
				}
				sum += weight;
			}
			if (bags > days) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
