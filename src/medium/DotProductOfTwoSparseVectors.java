package medium;

import java.util.HashMap;
import java.util.Map;

public class DotProductOfTwoSparseVectors {
	
	public static void main(String[] args) {
		SparseVector v1 = new SparseVector(new int[]{0, 1, 0, 0, 2, 0, 0});
		SparseVector v2 = new SparseVector(new int[]{1, 0, 0, 0, 3, 0, 4});
		int res = v1.dotProduct(v2);
		System.out.println(res);
	}
	
	static class SparseVector {
		
		Map<Integer, Integer> map;
		
		SparseVector(int[] nums) {
			map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					map.put(i, nums[i]);
				}
			}
		}
		
		public int dotProduct(SparseVector vec) {
			Map<Integer, Integer> vecMap = vec.map;
			if (map.size() > vecMap.size()) {
				return vec.dotProduct(this);
			}
			int product = 0;
			for (Integer i : map.keySet()) {
				if (vecMap.containsKey(i)) {
					product += map.get(i) * vecMap.get(i);
				}
			}
			return product;
		}
		
	}
}
