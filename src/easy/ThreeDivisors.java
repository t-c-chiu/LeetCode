package easy;

public class ThreeDivisors {
	
	public static void main(String[] args) {
		boolean res = isThree(81);
		System.out.println(res);
	}
	
	public static boolean isThree(int n) {
		int count = 2;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				count++;
			}
			if (count > 3) {
				return false;
			}
		}
		return count == 3;
	}
}
