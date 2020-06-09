package medium;

public class Find_the_Duplicate_Number {
	
	public static void main(String[] args) {
		Find_the_Duplicate_Number test = new Find_the_Duplicate_Number();
		int res = test.findDuplicate2(new int[]{1, 2, 3, 1});
		System.out.println(res);
	}
	
	public int findDuplicate(int[] nums) {
		int slow = nums[0], fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return fast;
	}
	
	public int findDuplicate2(int[] nums) {
		int left = 1, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int count = 0;
			for (int num : nums) {
				if (num <= mid) {
					count++;
				}
			}
			if (count <= mid) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
