package easy;

public class NonDecreasingArray {
	public static void main(String[] args) {
		NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
//		System.out.println(nonDecreasingArray.checkPossibility(new int[]{3, 4, 2, 3}));
//		System.out.println(nonDecreasingArray.checkPossibility(new int[]{4, 2, 1}));
		System.out.println(nonDecreasingArray.checkPossibility(new int[]{4, 2, 3}));
	}
	
	public boolean checkPossibility(int[] nums) {
		int count = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > nums[i]) {
				if (++count > 1)
					return false;
				if (i == 1 || nums[i - 2] <= nums[i])
					nums[i - 1] = nums[i]; // lower previous number
				else
					nums[i] = nums[i - 1]; // raise current number
			}
		}
		return true;
	}
}
