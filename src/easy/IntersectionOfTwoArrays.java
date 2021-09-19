package easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
	
	public static void main(String[] args) {
		int[] res = intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> interSection = new HashSet<>();
		for (int i : nums1) {
			set.add(i);
		}
		for (int i : nums2) {
			if (set.contains(i)) {
				interSection.add(i);
			}
		}
		int[] res = new int[interSection.size()];
		int i = 0;
		for (Integer num : interSection) {
			res[i++] = num;
		}
		return res;
	}
}
