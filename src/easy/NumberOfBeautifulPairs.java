package easy;

public class NumberOfBeautifulPairs {
	
	public static void main(String[] args) {
		int res = countBeautifulPairs(new int[]{11, 21, 12});
		System.out.println(res);
	}
	
	public static int countBeautifulPairs(int[] nums) {
		int n = nums.length, res = 0;
		for (int i = 0; i < n; i++) {
			int a = String.valueOf(nums[i]).charAt(0) - '0';
			for (int j = i + 1; j < n; j++) {
				int b = nums[j] % 10;
				if (gcd(a, b) == 1) {
					res++;
				}
			}
		}
		return res;
	}
	
	private static int gcd(int a, int b) {
		if (a > b) {
			return gcd(b, a);
		}
		if (b % a == 0) {
			return a;
		}
		return gcd(b % a, a);
	}
}
