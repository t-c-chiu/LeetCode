package easy;

public class Roman_to_Integer {
	
	public static void main(String[] args) {
		Roman_to_Integer test = new Roman_to_Integer();
		System.out.println(test.romanToInt("III"));
		System.out.println(test.romanToInt("IV"));
		System.out.println(test.romanToInt("IX"));
		System.out.println(test.romanToInt("LVIII"));
		System.out.println(test.romanToInt("MCMXCIV"));
	}
	
	//	Symbol       Value
	//	I             1
	//	V             5
	//	X             10
	//	L             50
	//	C             100
	//	D             500
	//	M             1000
	public int romanToInt(String s) {
		int sum = 0, len = s.length();
		int[] nums = new int[len];
		for (int i = 0; i < len; i++) {
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
		for (int i = 0; i < len - 1; i++) {
			if (nums[i] >= nums[i + 1])
				sum += nums[i];
			else
				sum -= nums[i];
		}
		sum += nums[len - 1];
		return sum;
	}
}
