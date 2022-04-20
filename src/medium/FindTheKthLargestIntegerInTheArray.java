package medium;

import java.util.Arrays;

public class FindTheKthLargestIntegerInTheArray {
	
	public static void main(String[] args) {
		String res = kthLargestNumber(new String[]{"2", "21", "12", "1"}, 3);
		System.out.println(res);
	}
	
	public static String kthLargestNumber(String[] nums, int k) {
		Arrays.sort(nums, (o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o2.compareTo(o1);
			}
			return o2.length() - o1.length();
		});
		return nums[k - 1];
	}
}
