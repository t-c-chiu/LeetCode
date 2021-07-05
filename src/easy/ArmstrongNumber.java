package easy;

public class ArmstrongNumber {
	
	public static void main(String[] args) {
		boolean res = isArmstrong(153);
		System.out.println(res);
	}
	
	public static boolean isArmstrong(int n) {
		int digit = String.valueOf(n).length();
		int tmp = n;
		int num = 0;
		while (tmp > 0) {
			num += Math.pow(tmp % 10, digit);
			tmp /= 10;
		}
		return num == n;
	}
}
