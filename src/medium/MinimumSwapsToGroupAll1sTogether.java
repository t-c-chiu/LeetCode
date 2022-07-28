package medium;

public class MinimumSwapsToGroupAll1sTogether {
	
	public static void main(String[] args) {
		int res = minSwaps(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1});
		System.out.println(res);
	}
	
	public static int minSwaps(int[] data) {
		int ones = 0;
		for (int i : data) {
			if (i == 1) {
				ones++;
			}
		}
		int res = Integer.MAX_VALUE, swap = 0;
		for (int r = 0, l = 0; r < data.length; r++) {
			if (data[r] == 0) {
				swap++;
			}
			if (r - l == ones) {
				if (data[l] == 0) {
					swap--;
				}
				l++;
			}
			if (r - l + 1 == ones) {
				res = Math.min(res, swap);
			}
		}
		return res;
	}
}
