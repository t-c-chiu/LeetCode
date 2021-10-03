package medium;

import java.util.Arrays;

public class FindMissingObservations {
	
	public static void main(String[] args) {
		int[] res = missingRolls(new int[]{6, 3, 4, 3, 5, 3}, 1, 6);
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] missingRolls(int[] rolls, int mean, int n) {
		int m = rolls.length;
		int sum = mean * (m + n);
		for (int roll : rolls) {
			sum -= roll;
		}
		if (sum < n || (double) sum / n > 6) {
			return new int[0];
		}
		int[] res = new int[n];
		int each = sum / n, addOne = sum % n;
		for (int i = 0; i < n; i++) {
			res[i] = each + (addOne > i ? 1 : 0);
		}
		return res;
	}
}
