package medium;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
	
	public static void main(String[] args) {
		int res = tupleSameProduct(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192});
		System.out.println(res);
	}
	
	public static int tupleSameProduct(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int product = nums[i] * nums[j];
				res += 8 * map.getOrDefault(product, 0);
				map.put(product, map.getOrDefault(product, 0) + 1);
			}
		}
		return res;
	}
	
	/**
	 * 3 -> 3*2/2=3
	 * 4 -> 4*3/2=6
	 * 5 -> 5*4/2=10
	 */
//	public static int tupleSameProduct(int[] nums) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				int product = nums[i] * nums[j];
//				map.put(product, map.getOrDefault(product, 0) + 1);
//			}
//		}
//		int res = 0;
//		for (Integer value : map.values()) {
//			if (value > 1) {
//				res += 8 * value * (value - 1) / 2;
//			}
//		}
//		return res;
//	}
}
