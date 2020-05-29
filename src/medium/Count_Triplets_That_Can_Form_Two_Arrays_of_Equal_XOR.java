package medium;

public class Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {
	
	public static void main(String[] args) {
		Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR test = new Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR();
		int res = test.countTriplets(new int[]{2, 3, 1, 6, 7});
		System.out.println(res);
	}
	
	public int countTriplets(int[] arr) {
		int i = 0, j, len = arr.length, res = 0;
		while (i < len - 1) {
			j = i + 1;
			while (j < len) {
				int left = 0;
				for (int k = i; k < j; k++) {
					left ^= arr[k];
				}
				int right = 0;
				for (int k = j; k < len; k++) {
					right ^= arr[k];
					if (left == right) {
						res++;
					}
				}
				j++;
			}
			i++;
		}
		return res;
	}
	
	/**
	 * a == b -> a ^ b = 0
	 * find (i, k) that arr[i] + arr[i + 1] + ... + arr[k] = 0
	 * for any j that i < j <= k fit the condition, so there will be k - i triplets
	 */
	public int countTriplets1(int[] arr) {
		int len = arr.length, res = 0;
		for (int i = 0; i < len - 1; i++) {
			int temp = arr[i];
			for (int k = i + 1; k < len; k++) {
				temp ^= arr[k];
				if (temp == 0) {
					res += k - i;
				}
			}
		}
		return res;
	}
}
