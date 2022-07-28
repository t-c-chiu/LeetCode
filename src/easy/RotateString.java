package easy;

public class RotateString {
	
	public static void main(String[] args) {
		boolean res = rotateString("abcde", "cdeab");
		System.out.println(res);
	}
	
	public static boolean rotateString(String s, String goal) {
		return s.length() == goal.length() && (s + s).contains(goal);
	}
//	public static boolean rotateString(String s, String goal) {
//		int n = s.length();
//		if (goal.length() != n) {
//			return false;
//		}
//		char c = s.charAt(0);
//		int start = 0;
//		while (goal.indexOf(c, start) != -1) {
//			int i = goal.indexOf(c, start);
//			if (s.equals(goal.substring(i) + goal.substring(0, i))) {
//				return true;
//			}
//			start = i + 1;
//		}
//		return false;
//	}
}
