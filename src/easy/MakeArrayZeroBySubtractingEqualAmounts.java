package easy;

import java.util.HashSet;
import java.util.Set;

public class MakeArrayZeroBySubtractingEqualAmounts {
	
	public static void main(String[] args) {
	
	}
	
	public static int minimumOperations(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (num > 0) {
				set.add(num);
			}
		}
		return set.size();
	}
}
