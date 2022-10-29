package easy;

public class RomanToInteger {
	
	public static void main(String[] args) {
//		System.out.println(romanToInt("III"));
//		System.out.println(romanToInt("IV"));
//		System.out.println(romanToInt("IX"));
//		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}
	
	//	Symbol       Value
	//	I             1
	//	V             5
	//	X             10
	//	L             50
	//	C             100
	//	D             500
	//	M             1000
	public static int romanToInt(String s) {
		int res = 0, n = s.length();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			switch (s.charAt(i)) {
				case 'I':
					nums[i] = 1;
					break;
				case 'V':
					nums[i] = 5;
					break;
				case 'X':
					nums[i] = 10;
					break;
				case 'L':
					nums[i] = 50;
					break;
				case 'C':
					nums[i] = 100;
					break;
				case 'D':
					nums[i] = 500;
					break;
				case 'M':
					nums[i] = 1000;
					break;
			}
		}
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] >= nums[i + 1]) {
				res += nums[i];
			} else {
				res -= nums[i];
			}
		}
		return res + nums[n - 1];
	}
}
