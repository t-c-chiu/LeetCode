package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheLatestTimeToCatchABus {
	
	public static void main(String[] args) {
		int res = latestTimeCatchTheBus(new int[]{3}, new int[]{4}, 1);
		System.out.println(res);
	}
	
	public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
		Arrays.sort(buses);
		Arrays.sort(passengers);
		int n = buses.length, m = passengers.length, j = 0;
		boolean full = false;
		for (int i = 0; i < n; i++) {
			int count = 0;
			full = false;
			while (count < capacity && j < m && passengers[j] <= buses[i]) {
				count++;
				j++;
			}
			if (count == capacity) {
				full = true;
			}
		}
		int res;
		if (full) {
			res = passengers[j - 1];
		} else {
			res = buses[n - 1];
		}
		Set<Integer> set = new HashSet<>();
		for (int passenger : passengers) {
			set.add(passenger);
		}
		for (int i = res; i >= 0; i--) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return 0;
	}
}
