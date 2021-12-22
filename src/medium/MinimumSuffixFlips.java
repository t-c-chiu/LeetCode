package medium;

public class MinimumSuffixFlips {
	
	public static void main(String[] args) {
		int res = minFlips("1110011001110110011");
		System.out.println(res);
	}
	
	public static int minFlips(String target) {
		int flips = 0;
		char status = '0';
		for (int i = 0; i < target.length(); i++) {
			if (status != target.charAt(i)) {
				flips++;
			}
			status = flips % 2 == 0 ? '0' : '1';
		}
		return flips;
	}

//	public static int minFlips(String target) {
//		int i = 0;
//		while (i < target.length() && target.charAt(i) == '0') {
//			i++;
//		}
//		target = target.substring(i);
//		if (target.isEmpty()) {
//			return 0;
//		}
//
//		int count = 1;
//		for (int j = 1; j < target.length(); j++) {
//			if (target.charAt(j) != target.charAt(j - 1)) {
//				count++;
//			}
//		}
//		return count;
//	}
}
