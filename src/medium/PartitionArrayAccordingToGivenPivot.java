package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayAccordingToGivenPivot {
	
	public static void main(String[] args) {
		int[] res = pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10);
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] pivotArray(int[] nums, int pivot) {
		int low = 0, same = 0, high;
		for (int num : nums) {
			if (num < pivot) {
				low++;
			} else if (num == pivot) {
				same++;
			}
		}
		high = low + same;
		same = low;
		low = 0;
		int[] res = new int[nums.length];
		for (int num : nums) {
			if (num < pivot) {
				res[low++] = num;
			} else if (num == pivot) {
				res[same++] = num;
			} else {
				res[high++] = num;
			}
		}
		return res;
	}
//	public static int[] pivotArray(int[] nums, int pivot) {
//		List<Integer> left = new ArrayList<>();
//		List<Integer> right = new ArrayList<>();
//		for (int num : nums) {
//			if (num < pivot) {
//				left.add(num);
//			} else if (num > pivot) {
//				right.add(num);
//			}
//		}
//		int[] res = new int[nums.length];
//		int i = 0;
//		for (Integer j : left) {
//			res[i++] = j;
//		}
//		for (int j = left.size() + right.size(); j < nums.length; j++) {
//			res[i++] = pivot;
//		}
//		for (Integer j : right) {
//			res[i++] = j;
//		}
//		return res;
//	}
}
