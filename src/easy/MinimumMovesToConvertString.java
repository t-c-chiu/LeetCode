package easy;

public class MinimumMovesToConvertString {
	
	public static void main(String[] args) {
		int res = minimumMoves("XXX");
		System.out.println(res);
	}
	
	public static int minimumMoves(String s) {
		char[] chars = s.toCharArray();
		int res = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 'X') {
				for (int j = i; j < i + 3 && j < chars.length; j++) {
					chars[j] = 'O';
				}
				res++;
			}
		}
		return res;
	}
}
