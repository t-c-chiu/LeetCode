package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
	
	public static void main(String[] args) {
		int[] res = nextGreaterElement(new int[]{4, 1, 2}, new int[]{4, 3, 2, 1});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int num : nums2) {
			while (!stack.isEmpty() && num > stack.peek()) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.getOrDefault(nums1[i], -1);
		}
		return res;
	}

//	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//		int[] res = new int[nums1.length];
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums2.length; i++) {
//			map.put(nums2[i], i);
//		}
//		for (int i = 0; i < nums1.length; i++) {
//			res[i] = -1;
//			for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
//				if (nums2[j] > nums1[i]) {
//					res[i] = nums2[j];
//					break;
//				}
//			}
//		}
//		return res;
//	}
}
