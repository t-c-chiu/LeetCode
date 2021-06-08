package easy;

public class SubstringsOfSizeThreeWithDistinctCharacters {
	
	public static void main(String[] args) {
		int res = countGoodSubstrings("aababcabc");
		System.out.println(res);
	}
	
	public static int countGoodSubstrings(String s) {
		int res = 0;
		for (int i = 2; i < s.length(); i++) {
			int c1 = s.charAt(i - 2);
			int c2 = s.charAt(i - 1);
			int c3 = s.charAt(i);
			if (c1 != c2 && c2 != c3 && c1 != c3) {
				res++;
			}
		}
		return res;
	}
}
