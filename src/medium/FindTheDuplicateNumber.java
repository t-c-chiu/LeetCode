package medium;

public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		int res = findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1});
		System.out.println(res);
	}
	
	public static int findDuplicate(int[] nums) {
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
		return slow;
	}
}
