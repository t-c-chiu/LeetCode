package easy;

import java.util.stream.IntStream;

public class MissingNumber {
	
	public static void main(String[] args) {
		MissingNumber missingNumber = new MissingNumber();
		System.out.println(missingNumber.missingNumber(new int[]{3, 0, 1}));
		System.out.println(missingNumber.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
	}
	
	public int missingNumber(int[] nums) {
		int len = nums.length;
		return (1 + len) * len / 2 - IntStream.of(nums).sum();
	}
}
