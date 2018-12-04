package easy;

public class ShortestUnsortedContinuousSubarray {
	public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray = new ShortestUnsortedContinuousSubarray();
		System.out.println(shortestUnsortedContinuousSubarray.
				findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
		System.out.println(shortestUnsortedContinuousSubarray.
				findUnsortedSubarray(new int[]{2, 1}));
		System.out.println(shortestUnsortedContinuousSubarray.
				findUnsortedSubarray(new int[]{1, 3, 2, 2, 2}));
	}

	public int findUnsortedSubarray(int[] nums) {
		int start = -1, end = -2, length = nums.length, min = nums[length - 1], max = nums[0];
		for (int i = 0; i < length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[length - 1 - i]);
			if (nums[i] < max)
				end = i;
			if (nums[length - 1 - i] > min)
				start = length - 1 - i;
		}
		return end - start + 1;
	}
}
