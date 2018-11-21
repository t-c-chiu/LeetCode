package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] res = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(nums[0], 0);
		for (int i = 1; i < nums.length; i++) {
			int firstNum = target - nums[i];
			if (map.containsKey(firstNum))
				return new int[]{map.get(firstNum), i};
			else
				map.put(nums[i], i);
		}
		return null;
	}
}
