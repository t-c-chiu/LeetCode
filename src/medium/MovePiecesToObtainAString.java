package medium;

public class MovePiecesToObtainAString {
	
	public static void main(String[] args) {
		boolean res = canChange("_L__R__R_", "L______RR");
		System.out.println(res);
	}
	
	public static boolean canChange(String start, String target) {
		int i = 0, j = 0, n = start.length();
		while (i < n && j < n) {
			while (i < n && start.charAt(i) == '_') {
				i++;
			}
			while (j < n && target.charAt(j) == '_') {
				j++;
			}
			if (i == n && j == n) {
				return true;
			}
			if (i == n || j == n || start.charAt(i) != target.charAt(j)
					|| start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R' && i > j) {
				return false;
			}
			i++;
			j++;
		}
		return true;
	}
}
