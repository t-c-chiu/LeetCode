package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
	
	public static void main(String[] args) {
		int res = subarraysDivByK(new int[]{-1, 2, 9}, 2);
		System.out.println(res);
	}
	
	public static int subarraysDivByK(int[] nums, int k) {
		Map<Integer, Integer> modCount = new HashMap<>();
		modCount.put(0, 1);
		int mod = 0, res = 0;
		for (int num : nums) {
			mod += num;
			mod %= k;
			if (mod < 0) {
				mod += k;
			}
			res += modCount.getOrDefault(mod, 0);
			modCount.put(mod, modCount.getOrDefault(mod, 0) + 1);
		}
		return res;
	}
}
