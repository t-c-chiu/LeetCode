package easy;

public class SingleNumber {
	public static void main(String[] args) {
		SingleNumber singleNumber = new SingleNumber();
		System.out.println(singleNumber.singleNumber(new int[]{4, 1, 2, 2, 1}));
		System.out.println(singleNumber.singleNumber(new int[]{4, 1, 2, 7, 4, 2, 1}));
	}

	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i : nums)
			res ^= i;
		return res;
	}
}