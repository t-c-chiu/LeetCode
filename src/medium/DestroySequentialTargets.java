package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DestroySequentialTargets {
	
	public static void main(String[] args) {
		int res = destroyTargets(new int[]{6, 2, 5}, 100);
		System.out.println(res);
	}
	
	public static int destroyTargets(int[] nums, int space) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int num : nums) {
			int mod = num % space;
			map.put(mod, map.getOrDefault(mod, 0) + 1);
			max = Math.max(max, map.get(mod));
		}
		Arrays.sort(nums);
		for (int num : nums) {
			if (map.get(num % space) == max) {
				return num;
			}
		}
		return -1;
	}
}
