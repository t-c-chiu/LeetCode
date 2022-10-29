package medium;

public class NumberOfWaysToSelectBuildings {
	
	public static void main(String[] args) {
		long res = numberOfWays("001101");
		System.out.println(res);
	}
	
	public static long numberOfWays(String s) {
		long one = 0, zero = 0, oneZero = 0, zeroOne = 0, res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				zero++;
				oneZero += one;
				res += zeroOne;
			} else {
				one++;
				zeroOne += zero;
				res += oneZero;
			}
		}
		return res;
	}
//	public static long numberOfWays(String s) {
//		long res = 0;
//		int oneCount = 0, zeroCount = 0;
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) == '0') {
//				zeroCount++;
//			} else {
//				oneCount++;
//			}
//		}
//		int curOne = 0, curZero = 0;
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) == '0') {
//				res += (long) curOne * (oneCount - curOne);
//				curZero++;
//			} else {
//				res += (long) curZero * (zeroCount - curZero);
//				curOne++;
//			}
//		}
//		return res;
//	}

//	public static long numberOfWays(String s) {
//		int n = s.length();
//		long[] n0 = new long[n], n1 = new long[n];
//		if (s.charAt(0) == '0') {
//			n0[0] = 1;
//		} else {
//			n1[0] = 1;
//		}
//		for (int i = 1; i < s.length(); i++) {
//			n0[i] = n0[i - 1];
//			n1[i] = n1[i - 1];
//			if (s.charAt(i) == '0') {
//				n0[i]++;
//			} else {
//				n1[i]++;
//			}
//		}
//		long[] n01 = new long[n], n10 = new long[n];
//		for (int i = 1; i < n; i++) {
//			n01[i] = n01[i - 1];
//			n10[i] = n10[i - 1];
//			if (s.charAt(i) == '0') {
//				n10[i] += n1[i - 1];
//			} else {
//				n01[i] += n0[i - 1];
//			}
//		}
//		long[] n101 = new long[n], n010 = new long[n];
//		for (int i = 2; i < n; i++) {
//			n101[i] = n101[i - 1];
//			n010[i] = n010[i - 1];
//			if (s.charAt(i) == '0') {
//				n010[i] += n01[i - 1];
//			} else {
//				n101[i] += n10[i - 1];
//			}
//		}
//		return n101[n - 1] + n010[n - 1];
//	}
	
}
