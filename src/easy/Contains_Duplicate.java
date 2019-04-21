package easy;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {
	public static void main(String[] args) {
		Contains_Duplicate test = new Contains_Duplicate();
		System.out.println(test.containsDuplicate(new int[]{1, 1, 2, 3}));
		System.out.println(test.containsDuplicate(new int[]{1, 2, 3, 4, 5}));
	}
	
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (!set.add(i))
				return true;
		}
		return false;
	}
}
