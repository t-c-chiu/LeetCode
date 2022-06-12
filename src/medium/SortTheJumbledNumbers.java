package medium;

import java.util.*;

public class SortTheJumbledNumbers {
	
	public static void main(String[] args) {
		int[] res = sortJumbled(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] sortJumbled(int[] mapping, int[] nums) {
		int n = nums.length;
		Integer[] indices = new Integer[n];
		for (int i = 0; i < n; i++) {
			indices[i] = i;
		}
		Arrays.sort(indices, Comparator.comparingInt(i -> convert(nums[i], mapping)));
		int[] res = new int[n];
		int i = 0;
		for (Integer index : indices) {
			res[i++] = nums[index];
		}
		return res;
	}
	
	private static int convert(int num, int[] mapping) {
		if (num == 0) {
			return mapping[0];
		}
		int mappedNum = 0;
		int multiply = 1;
		while (num > 0) {
			mappedNum += mapping[num % 10] * multiply;
			num /= 10;
			multiply *= 10;
		}
		return mappedNum;
	}
}
