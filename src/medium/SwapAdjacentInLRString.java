package medium;

public class SwapAdjacentInLRString {
	
	public static void main(String[] args) {
		boolean res = canTransform("RXXLRXRXL", "XRLXXRRLX");
		System.out.println(res);
	}
	
	public static boolean canTransform(String start, String end) {
		int i = 0, j = 0, m = start.length(), n = end.length();
		while (i < m || j < n) {
			while (i < m && start.charAt(i) == 'X') {
				i++;
			}
			while (j < n && end.charAt(j) == 'X') {
				j++;
			}
			if (i == m || j == n) {
				break;
			}
			char c1 = start.charAt(i);
			char c2 = end.charAt(j);
			if (c1 != c2 || c1 == 'R' && i > j || c1 == 'L' && i < j) {
				return false;
			}
			i++;
			j++;
		}
		return i == m && j == n;
	}
}
