package medium;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {
	
	public static void main(String[] args) {
		int res = minSubarray(new int[]{3, 1, 4, 2}, 6);
		System.out.println(res);
	}
	
	public static int minSubarray(int[] nums, int p) {
		int n = nums.length, cur = 0, res = n, target = 0;
		for (int num : nums) {
			target = (target + num) % p;
		}
		if (target == 0) {
			return 0;
		}
		Map<Integer, Integer> pos = new HashMap<>();
		pos.put(0, -1);
		for (int i = 0; i < n; i++) {
			cur = (cur + nums[i]) % p;
			int want = (cur - target + p) % p;
			if (pos.containsKey(want)) {
				res = Math.min(res, i - pos.get(want));
			}
			pos.put(cur, i);
		}
		return res < n ? res : -1;
	}
}
