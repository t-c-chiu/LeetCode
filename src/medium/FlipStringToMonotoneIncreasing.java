package medium;

public class FlipStringToMonotoneIncreasing {
	
	public static void main(String[] args) {
		int res = minFlipsMonoIncr("00011000");
		System.out.println(res);
	}
	
	public static int minFlipsMonoIncr(String s) {
		int oneCount = 0, flip = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '1') {
				oneCount++;
			} else {
				flip++;
			}
			flip = Math.min(oneCount, flip);
		}
		return flip;
	}
}
