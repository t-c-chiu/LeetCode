package hard;

public class ConsecutiveNumbersSum {
	
	public static void main(String[] args) {
		int res = consecutiveNumbersSum(15);
		System.out.println(res);
	}
	
	/**
	 * 15 = (14+1), 14 * 1 = 15 - 1, 14 = (15-1)%1
	 * 15 = (6+1) + (6+2), 6 * 2 = 15 - 1 - 2, 6 = (15-1-2)%2
	 * 15 = (3+1) + (3+2) + (3+3), 3 * 3 = 15 - 1 - 2 - 3, 3 = (15-1-2-3)%3
	 * 15 = 1 + 2 + 3 + 4 + 5, 0 * 5 = 15 - 1 - 2 - 3 - 4 - 5, 0 = (15-1-2-3-4-5)%5
	 */
	public static int consecutiveNumbersSum(int n) {
		int res = 0, i = 1;
		while (n > 0) {
			n -= i;
			if (n % i == 0) {
				res++;
			}
			i++;
		}
		return res;
	}
}
