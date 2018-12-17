package medium;

public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
//		System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2}));
		System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{3, 2, 3, 1, 4}));
	}
	
	public int findDuplicate(int[] nums) {
		int left = 1, right = nums.length;
		while (left < right) {
			int count = 0, mid = (right + left) / 2;
			for (int num : nums) {
				if (num <= mid)
					count++;
			}
			if (count <= mid)
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
}
