package medium;

public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		int res = findDuplicate(new int[]{1, 2, 3, 4, 2});
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
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}
}
