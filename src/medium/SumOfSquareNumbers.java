package medium;

public class SumOfSquareNumbers {
	
	public static void main(String[] args) {
		boolean res = judgeSquareSum(2147483600);
		System.out.println(res);
	}
	
	public static boolean judgeSquareSum(int c) {
		int left = 0, right = (int) Math.sqrt(c);
		while (left <= right) {
			long cur = (long) left * left + (long) right * right;
			if (cur == c) {
				return true;
			} else if (cur < c) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}
}
