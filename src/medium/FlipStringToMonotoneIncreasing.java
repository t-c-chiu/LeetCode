package medium;

public class FlipStringToMonotoneIncreasing {
	
	public static void main(String[] args) {
		int res = minFlipsMonoIncr("010110");
		System.out.println(res);
	}
	
	public static int minFlipsMonoIncr(String s) {
		int oneCount = 0, flipCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (oneCount == 0) {
					continue;
				}
				flipCount++;
			} else {
				oneCount++;
			}
			if (flipCount > oneCount) {
				flipCount = oneCount;
			}
		}
		return flipCount;
	}
}
