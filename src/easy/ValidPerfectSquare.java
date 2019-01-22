package easy;

public class ValidPerfectSquare {
	public static void main(String[] args) {
		ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
		System.out.println(validPerfectSquare.isPerfectSquare(5));
		System.out.println(validPerfectSquare.isPerfectSquare(14));
	}

	public boolean isPerfectSquare(int num) {
		for (int i = 1; i <= num / i; i++) {
			if (i * i == num)
				return true;
		}
		return false;
	}
}
