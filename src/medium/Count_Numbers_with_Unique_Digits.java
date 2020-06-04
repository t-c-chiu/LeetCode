package medium;

public class Count_Numbers_with_Unique_Digits {
	
	public static void main(String[] args) {
		Count_Numbers_with_Unique_Digits test = new Count_Numbers_with_Unique_Digits();
		int res = test.countNumbersWithUniqueDigits(3);
		System.out.println(res);
	}
	
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		
		// 0 ~ 9
		int res = 10;
		if (n > 1) {
			// more than two digits, first digit is 1 ~ 9, remaining digits could be 0 ~ 9 but not repeat with used digits.
			// so it's 9 * 9 * 8 * 7 * ...
			int uniqueDigits = 9;
			for (int i = 1; i < n; i++) {
				uniqueDigits *= (10 - i);
				res += uniqueDigits;
			}
		}
		return res;
	}
}
