package easy;

public class Power_of_Three {
	
	public static void main(String[] args) {
		Power_of_Three test = new Power_of_Three();
		System.out.println(test.isPowerOfThree(0));
		System.out.println(test.isPowerOfThree(9));
		System.out.println(test.isPowerOfThree(27));
		System.out.println(test.isPowerOfThree(45));
	}
	
	public boolean isPowerOfThree(int n) {
		if (n == 1)
			return true;
		if (n == 0 || n % 3 != 0)
			return false;
		return isPowerOfThree(n / 3);
	}
}