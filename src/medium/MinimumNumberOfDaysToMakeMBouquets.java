package medium;

public class MinimumNumberOfDaysToMakeMBouquets {
	
	public static void main(String[] args) {
		int res = minDays(new int[]{1, 10, 3, 10, 2}, 3, 2);
		System.out.println(res);
	}
	
	public static int minDays(int[] bloomDay, int m, int k) {
		if (m * k > bloomDay.length) {
			return -1;
		}
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i : bloomDay) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		
		while (min < max) {
			int mid = (min + max) / 2;
			int bouquets = getBouquets(bloomDay, mid, k);
			if (bouquets < m) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}
	
	private static int getBouquets(int[] bloomDay, int day, int k) {
		int bouquets = 0, flower = 0;
		for (int i : bloomDay) {
			if (i <= day) {
				flower++;
			} else {
				flower = 0;
			}
			
			if (flower == k) {
				bouquets++;
				flower = 0;
			}
		}
		return bouquets;
	}
}
