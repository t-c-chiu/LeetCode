package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Third_Maximum_Number {
	
	public static void main(String[] args) {
		Third_Maximum_Number test = new Third_Maximum_Number();
		System.out.println(test.thirdMax(new int[]{3, 2, 1}));
		System.out.println(test.thirdMax(new int[]{1, 2}));
		System.out.println(test.thirdMax(new int[]{2, 2, 3, 1}));
	}
	
	public int thirdMax(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		Integer[] array = set.toArray(new Integer[0]);
		Arrays.sort(array);
		int len = array.length;
		if (len < 3)
			return array[len - 1];
		return array[len - 3];
	}
	
	public int thirdMax2(int[] nums) {
		Integer max1 = null, max2 = null, max3 = null;
		for (Integer i : nums) {
			if (i.equals(max1) || i.equals(max2) || i.equals(max3))
				continue;
			if (max1 == null || i > max1) {
				max3 = max2;
				max2 = max1;
				max1 = i;
			} else if (max2 == null || i > max2) {
				max3 = max2;
				max2 = i;
			} else if (max3 == null || i > max3) {
				max3 = i;
			}
		}
		return max3 == null ? max1 : max3;
	}
}
