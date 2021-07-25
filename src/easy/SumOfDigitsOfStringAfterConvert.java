package easy;

public class SumOfDigitsOfStringAfterConvert {
	
	public static void main(String[] args) {
		int res = getLucky("leetcode", 2);
		System.out.println(res);
	}
	
	public static int getLucky(String s, int k) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			builder.append(s.charAt(i) - 'a' + 1);
		}
		
		String str = builder.toString();
		int res = 0;
		while (k > 0) {
			res = 0;
			for (int i = 0; i < str.length(); i++) {
				res += str.charAt(i) - '0';
			}
			str = String.valueOf(res);
			k--;
		}
		return res;
	}
}
