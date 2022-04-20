package medium;

public class FindTheSmallestDivisorGivenAThreshold {
	
	public static void main(String[] args) {
		int res = smallestDivisor(new int[]{21212, 10101, 12121}, 1000000);
		System.out.println(res);
	}
	
	public static int smallestDivisor(int[] nums, int threshold) {
		int lo = 1, hi = (int) 1e6;
		while (lo < hi) {
			int divisor = (lo + hi) / 2;
			int sum = 0;
			for (int num : nums) {
				sum += num / divisor;
				if (num % divisor != 0) {
					sum++;
				}
			}
			if (sum > threshold) {
				lo = divisor + 1;
			} else {
				hi = divisor;
			}
		}
		return hi;
	}
}
