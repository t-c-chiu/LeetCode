package medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	
	public static void main(String[] args) {
		List<Integer> res = majorityElement(new int[]{2, 2, 1, 3});
		System.out.println(res);
	}
	
	public static List<Integer> majorityElement(int[] nums) {
		int candidate1 = 0;
		int candidate2 = 0;
		int count1 = 0;
		int count2 = 0;
		for (int num : nums) {
			if (num == candidate1) {
				count1++;
			} else if (num == candidate2) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = num;
				count1++;
			} else if (count2 == 0) {
				candidate2 = num;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num == candidate1) {
				count1++;
			} else if (num == candidate2) {
				count2++;
			}
		}
		int k = nums.length / 3;
		List<Integer> res = new ArrayList<>();
		if (count1 > k) {
			res.add(candidate1);
		}
		if (count2 > k) {
			res.add(candidate2);
		}
		return res;
	}
}
