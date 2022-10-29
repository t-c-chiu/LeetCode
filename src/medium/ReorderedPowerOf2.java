package medium;

import java.util.Arrays;

public class ReorderedPowerOf2 {
	
	public static void main(String[] args) {
		boolean res = reorderedPowerOf2(1);
		System.out.println(res);
	}
	
	public static boolean reorderedPowerOf2(int n) {
		int[] count = count(n);
		for (int i = 0; i < 32; i++) {
			if (Arrays.equals(count, count(1 << i))) {
				return true;
			}
		}
		return false;
	}
	
	private static int[] count(int n) {
		int[] count = new int[10];
		while (n > 0) {
			count[n % 10]++;
			n /= 10;
		}
		return count;
	}
}
