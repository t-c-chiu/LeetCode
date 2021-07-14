package easy;

public class ConcatenationOfArray {
	
	public int[] getConcatenation(int[] nums) {
		int n = nums.length;
		int[] res = new int[n * 2];
		int i = 0;
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < n; k++) {
				res[i++] = nums[k];
			}
		}
		return res;
	}
}
