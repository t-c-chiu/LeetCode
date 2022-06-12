package medium;


import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
	
	public static void main(String[] args) {
		boolean res = hasAllCodes("00110", 2);
		System.out.println(res);
	}
	
	public static boolean hasAllCodes(String s, int k) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i + k <= s.length(); i++) {
			set.add(s.substring(i, i + k));
		}
		return set.size() == Math.pow(2, k);
	}
}
