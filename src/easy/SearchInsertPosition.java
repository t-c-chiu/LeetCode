package easy;

public class SearchInsertPosition {
	
	public static void main(String[] args) {
		SearchInsertPosition test = new SearchInsertPosition();
		int ans = test.searchInsert(new int[]{1, 3, 5, 6}, 5);
		System.out.println(ans);
		ans = test.searchInsert(new int[]{1, 3, 5, 6}, 2);
		System.out.println(ans);
		ans = test.searchInsert(new int[]{1, 3, 5, 6}, 7);
		System.out.println(ans);
		ans = test.searchInsert(new int[]{1, 3, 5, 6}, 0);
		System.out.println(ans);
	}
	
	public int searchInsert(int[] nums, int target) {
		if (target < nums[0])
			return 0;
		final int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (target == nums[i] || i > 0 && target > nums[i - 1] && target < nums[i])
				return i;
		}
		return len;
	}
}
