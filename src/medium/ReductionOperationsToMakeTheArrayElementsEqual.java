package medium;

import java.util.Arrays;
import java.util.TreeMap;

public class ReductionOperationsToMakeTheArrayElementsEqual {
	
	public static void main(String[] args) {
		int res = reductionOperations(new int[]{1, 1, 2, 2, 3});
		System.out.println(res);
	}
	
	public static int reductionOperations(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int res = 0;
		for (int i = n - 1; i > 0; i--) {
			if (nums[i - 1] != nums[i]) {
				res += n - i;
			}
		}
		return res;
	}
//	public static int reductionOperations(int[] nums) {
//		Arrays.sort(nums);
//		int n = nums.length;
//		int largest = nums[n - 1];
//		int largestCount = 0;
//		int res = 0;
//		for (int i = n - 1; i > 0; i--) {
//			if (nums[0] == largest) {
//				break;
//			}
//			if (nums[i] != largest) {
//				largest = nums[i];
//				res += largestCount;
//			}
//			largestCount++;
//		}
//		return res;
//	}

//	public static int reductionOperations(int[] nums) {
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		for (int num : nums) {
//			map.put(num, map.getOrDefault(num, 0) + 1);
//		}
//		int res = 0;
//		while (map.size() > 1) {
//			int largest = map.lastKey();
//			int largestCount = map.get(largest);
//			int nextLargest = map.lowerKey(largest);
//			res += largestCount;
//			map.remove(largest);
//			map.put(nextLargest, map.get(nextLargest) + largestCount);
//		}
//		return res;
//	}
}
