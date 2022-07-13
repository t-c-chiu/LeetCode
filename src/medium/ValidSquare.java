package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSquare {
	
	public static void main(String[] args) {
		boolean res = validSquare(new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 0}, new int[]{1, 1});
		System.out.println(res);
	}
	
	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		Set<Integer> set = new HashSet<>(Arrays.asList(getD(p1, p2), getD(p1, p3), getD(p1, p4), getD(p2, p3), getD(p2, p4), getD(p3, p4)));
		return !set.contains(0) && set.size() == 2;
	}
	
	private static int getD(int[] from, int[] to) {
		return Math.abs(from[0] - to[0]) * Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]) * Math.abs(from[1] - to[1]);
	}
	
}
