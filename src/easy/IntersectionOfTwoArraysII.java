package easy;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArraysII {
	
	public static void main(String[] args) {
		int[] res = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
		int n = 1001;
		int[] count1 = new int[n], count2 = new int[n];
		for (int i : nums1) {
			count1[i]++;
		}
		for (int i : nums2) {
			count2[i]++;
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < Math.min(count1[i], count2[i]); j++) {
				list.add(i);
			}
		}
		
		int i = 0;
		int[] res = new int[list.size()];
		for (Integer num : list) {
			res[i++] = num;
		}
		return res;
	}
}
