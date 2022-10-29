package medium;

import java.util.Arrays;
import java.util.TreeSet;

public class NextClosestTime {
	
	public static void main(String[] args) {
		String res = nextClosestTime("23:59");
		System.out.println(res);
	}
	
	public static String nextClosestTime(String time) {
		char[] res = time.toCharArray();
		TreeSet<Character> set = new TreeSet<>(Arrays.asList(time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)));
		res[4] = findNext(time.charAt(4), '9', set);
		if (res[4] > time.charAt(4)) {
			return new String(res);
		}
		res[3] = findNext(time.charAt(3), '5', set);
		if (res[3] > time.charAt(3)) {
			return new String(res);
		}
		res[1] = findNext(time.charAt(1), time.charAt(0) == '2' ? '3' : '9', set);
		if (res[1] > time.charAt(1)) {
			return new String(res);
		}
		res[0] = findNext(time.charAt(0), time.charAt(1) <= '3' ? '2' : '1', set);
		return new String(res);
	}
	
	private static char findNext(char c, char limit, TreeSet<Character> set) {
		Character next = set.higher(c);
		return next == null || next > limit ? set.first() : next;
	}
	
}
