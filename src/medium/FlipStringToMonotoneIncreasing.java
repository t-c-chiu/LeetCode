package medium;

public class FlipStringToMonotoneIncreasing {
	
	public static void main(String[] args) {
		int res = minFlipsMonoIncr("00011000");
		System.out.println(res);
	}
	
	public static int minFlipsMonoIncr(String s) {
		int flip = 0, oneCounts = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				oneCounts++;
			} else {
				flip++;
			}
			flip = Math.min(flip, oneCounts);
		}
		return flip;
	}
}
