package easy;

public class Remove_Duplicates_from_Sorted_Array {
	public static void main(String[] args) {
		Remove_Duplicates_from_Sorted_Array test = new Remove_Duplicates_from_Sorted_Array();
		System.out.println(test.removeDuplicates(new int[]{1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5}));
	}
	
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int j = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != nums[j])
				nums[++j] = nums[i];
		return ++j;
	}
}
