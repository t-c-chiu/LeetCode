package easy;

public class MinimumTimeToTypeWordUsingSpecialTypewriter {
	
	public static void main(String[] args) {
		int res = minTimeToType("zjpc");
		System.out.println(res);
	}
	
	public static int minTimeToType(String word) {
		int res = 0;
		char cur = 'a';
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			res += getMinTime(cur, c);
			res++;
			cur = c;
		}
		return res;
	}
	
	private static int getMinTime(char c1, char c2) {
		if (c2 > c1) {
			return getMinTime(c2, c1);
		}
		return Math.min(c1 - c2, 'z' - c1 + c2 - 'a' + 1);
	}
}
