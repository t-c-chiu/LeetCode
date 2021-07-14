package medium;

import java.util.TreeSet;

public class NextClosestTime {
	
	public static void main(String[] args) {
		String res = nextClosestTime("23:59");
		System.out.println(res);
	}
	
	public static String nextClosestTime(String time) {
		TreeSet<Character> digits = new TreeSet<>();
		for (int i = 0; i < time.length(); i++) {
			char c = time.charAt(i);
			if (c != ':') {
				digits.add(c);
			}
		}
		
		char[] res = time.toCharArray();
		res[4] = findNext(time.charAt(4), '9', digits);
		if (res[4] > time.charAt(4)) {
			return String.valueOf(res);
		}
		
		res[3] = findNext(time.charAt(3), '5', digits);
		if (res[3] > time.charAt(3)) {
			return String.valueOf(res);
		}
		
		res[1] = findNext(time.charAt(1), res[0] == '2' ? '3' : '9', digits);
		if (res[1] > time.charAt(1)) {
			return String.valueOf(res);
		}
		
		res[0] = findNext(time.charAt(0), '2', digits);
		return String.valueOf(res);
	}
	
	private static char findNext(char c, char limit, TreeSet<Character> digits) {
		Character higher = digits.higher(c);
		return higher == null || higher > limit ? digits.first() : higher;
	}
}
