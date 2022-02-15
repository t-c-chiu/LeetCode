package medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	
	public static void main(String[] args) {
		List<String> res = restoreIpAddresses("25525511135");
		System.out.println(res);
	}
	
	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		int n = s.length();
		for (int i = 1; i <= 3 && i < n - 2; i++) {
			for (int j = i + 1; j <= i + 3 && j < n - 1; j++) {
				for (int k = j + 1; k <= j + 3 && k < n; k++) {
					String s1 = s.substring(0, i);
					String s2 = s.substring(i, j);
					String s3 = s.substring(j, k);
					String s4 = s.substring(k, n);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						res.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
					}
				}
			}
		}
		return res;
	}
	
	private static boolean isValid(String s) {
		return s.length() != 0 && s.length() <= 3 && (s.charAt(0) != '0' || s.length() <= 1) && Integer.parseInt(s) <= 255;
	}
}
