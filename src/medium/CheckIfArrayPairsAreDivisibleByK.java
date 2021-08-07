package medium;

public class CheckIfArrayPairsAreDivisibleByK {
	
	public static void main(String[] args) {
		boolean res = canArrange(new int[]{1, -1, -2, 2, -3, 3, -4, 4}, 3);
		System.out.println(res);
	}
	
	
	public static boolean canArrange(int[] arr, int k) {
		int[] freq = new int[k];
		for (int i : arr) {
			i %= k;
			if (i < 0) {
				i += k;
			}
			freq[i]++;
		}
		if (freq[0] % 2 != 0) {
			return false;
		}
		for (int i = 1; i <= k / 2; i++) {
			if (freq[i] != freq[k - i]) {
				return false;
			}
		}
		return true;
	}
}
