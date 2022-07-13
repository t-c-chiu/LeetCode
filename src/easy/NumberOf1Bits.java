package easy;

public class NumberOf1Bits {
	public static void main(String[] args) {
		System.out.println(hammingWeight(1));
		System.out.println(hammingWeight(2));
		System.out.println(hammingWeight(3));
		System.out.println(hammingWeight(4));
		System.out.println(hammingWeight(5));
		System.out.println(hammingWeight(-3));
	}
	
	public static int hammingWeight(int n) {
		int res = 0;
		while (n != 0) {
			res += (n & 1);
			n >>>= 1;
		}
		return res;
	}
//	public static int hammingWeight(int n) {
//		int res = 0;
//		for (int i = 0; i < 32; i++) {
//			if ((n & 1 << i) == 1 << i) {
//				res++;
//			}
//		}
//		return res;
//	}
}
