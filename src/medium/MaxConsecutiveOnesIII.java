package medium;

public class MaxConsecutiveOnesIII {
	
	public static void main(String[] args) {
		MaxConsecutiveOnesIII test = new MaxConsecutiveOnesIII();
		System.out.println(test.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
		System.out.println(test.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
	}
	
	public int longestOnes(int[] nums, int k) {
		int left = 0, max = 0;
		for (int right = 0; right < nums.length; right++) {
			if (nums[right] == 0)
				k--;
			if (k < 0 && nums[left++] == 0)
				k++;
			max = right - left + 1;
		}
		return max;
	}
}
