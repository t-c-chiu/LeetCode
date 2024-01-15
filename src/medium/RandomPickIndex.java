package medium;

import java.util.*;

public class RandomPickIndex {
	
	public static void main(String[] args) {
		Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
		solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
		solution.pick(1); // It should return 0. Since in the array only nums[0] is equal to 1.
		solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
	}
	
	static class Solution {
		
		Map<Integer, List<Integer>> map;
		
		public Solution(int[] nums) {
			map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				map.putIfAbsent(nums[i], new ArrayList<>());
				map.get(nums[i]).add(i);
			}
		}
		
		public int pick(int target) {
			List<Integer> list = map.get(target);
			return list.get(new Random().nextInt(list.size()));
		}
	}
}
