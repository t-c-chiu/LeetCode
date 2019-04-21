package easy;

import java.util.HashSet;
import java.util.Set;

public class Intersection_of_Two_Arrays {
	public static void main(String[] args) {
		Intersection_of_Two_Arrays test = new Intersection_of_Two_Arrays();
		
	}
	
	
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		for (int i : nums1)
			set1.add(i);
		Set<Integer> set2 = new HashSet<>();
		for (int i : nums2) {
			if (set1.contains(i))
				set2.add(i);
		}
		return set2.stream().mapToInt(i -> i).toArray();
	}
}
