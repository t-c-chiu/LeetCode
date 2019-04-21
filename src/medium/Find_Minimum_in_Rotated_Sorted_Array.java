package medium;

public class Find_Minimum_in_Rotated_Sorted_Array {
	
	public static void main(String[] args) {
		Find_Minimum_in_Rotated_Sorted_Array test = new Find_Minimum_in_Rotated_Sorted_Array();
		System.out.println(test.findMin(new int[]{3, 4, 5, 1, 2}));
		System.out.println(test.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
		System.out.println(test.findMin(new int[]{2, 1}));
	}
	
	
	public int findMin(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++)
			if (nums[i + 1] < nums[i])
				return nums[i + 1];
		return nums[0];
	}
}
