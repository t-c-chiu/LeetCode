package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInAnArray {
	
	public static void main(String[] args) {
		int[] res = arrayChange(new int[]{1, 2, 4, 6}, new int[][]{{1, 3}, {4, 7}, {6, 1}});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] arrayChange(int[] nums, int[][] operations) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int[] op : operations) {
			int index = map.get(op[0]);
			nums[index] = op[1];
			map.put(op[1], index);
		}
		return nums;
	}
}
