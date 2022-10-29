package easy;

public class NumberOfCommonFactors {
	
	public static void main(String[] args) {
		int res = commonFactors(6, 12);
		System.out.println(res);
	}
	
	public static int commonFactors(int a, int b) {
		if (a > b) {
			return commonFactors(b, a);
		}
		int res = 0;
		for (int i = 1; i <= a; i++) {
			if (a % i == 0 && b % i == 0) {
				res++;
			}
		}
		return res;
	}
	
}
