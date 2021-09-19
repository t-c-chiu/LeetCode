package medium;

public class BrokenCalculator {
	
	public static void main(String[] args) {
		int res = brokenCalc(1, 21);
		System.out.println(res);
	}
	
	public static int brokenCalc(int startValue, int target) {
		int res = 0;
		while (target > startValue) {
			target = target % 2 == 0 ? target / 2 : target + 1;
			res++;
		}
		return res + startValue - target;
	}
}
