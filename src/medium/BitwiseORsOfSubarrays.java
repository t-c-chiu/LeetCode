package medium;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarrays {
	
	public static void main(String[] args) {
		int res = subarrayBitwiseORs(new int[]{1, 2, 4});
		System.out.println(res);
	}
	
	public static int subarrayBitwiseORs(int[] arr) {
		Set<Integer> res = new HashSet<>(), cur = new HashSet<>();
		for (int i : arr) {
			Set<Integer> next = new HashSet<>();
			next.add(i);
			for (int j : cur) {
				next.add(j | i);
			}
			cur = next;
			res.addAll(cur);
		}
		return res.size();
	}
}
