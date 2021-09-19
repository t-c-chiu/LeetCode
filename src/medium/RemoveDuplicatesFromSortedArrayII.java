package medium;

public class RemoveDuplicatesFromSortedArrayII {
	
	public static void main(String[] args) {
		int res = removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
		System.out.println(res);
	}
	
	public static int removeDuplicates(int[] nums) {
		int i = 0;
		for (int num : nums) {
			if (i < 2 || num > nums[i - 2]) {
				nums[i++] = num;
			}
		}
		return i;
	}

//	public static int removeDuplicates(int[] nums) {
//		int i = 0, count = 1;
//		for (int j = 1; j < nums.length; j++) {
//			if (nums[i] == nums[j] && count < 2) {
//				nums[++i] = nums[j];
//				count++;
//			} else if (nums[i] != nums[j]) {
//				nums[++i] = nums[j];
//				count = 1;
//			}
//		}
//		return ++i;
//	}
}
