package medium;

public class MinimumSwapsToGroupAll1sTogether {
	
	public static void main(String[] args) {
		int res = minSwaps(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1});
		System.out.println(res);
	}
	
	public static int minSwaps(int[] data) {
		int oneCount = 0;
		for (int num : data) {
			if (num == 1) {
				oneCount++;
			}
		}
		int swap = 0;
		for (int i = 0; i < oneCount; i++) {
			if (data[i] == 0) {
				swap++;
			}
		}
		int res = swap, left = 1, right = oneCount;
		while (right < data.length) {
			if (data[left - 1] == 0) {
				swap--;
			}
			if (data[right] == 0) {
				swap++;
			}
			res = Math.min(res, swap);
			left++;
			right++;
		}
		return res;
	}
}
