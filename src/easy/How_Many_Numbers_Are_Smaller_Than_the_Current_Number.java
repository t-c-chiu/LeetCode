package easy;

public class How_Many_Numbers_Are_Smaller_Than_the_Current_Number {
	
	public static void main(String[] args) {
		How_Many_Numbers_Are_Smaller_Than_the_Current_Number test = new How_Many_Numbers_Are_Smaller_Than_the_Current_Number();
		int[] res = test.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8});
		for (int i : res) {
			System.out.println(i);
		}
	}
	
	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] count = new int[101];
		for (int num : nums) {
			count[num]++;
		}
		for (int i = 1; i < 101; i++) {
			count[i] += count[i - 1];
		}
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				res[i] = 0;
			} else {
				res[i] = count[nums[i] - 1];
			}
		}
		return res;
	}
}
