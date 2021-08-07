package medium;


import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
	
	public static void main(String[] args) {
		boolean res = hasAllCodes("00110", 2);
		System.out.println(res);
	}
	
	public static boolean hasAllCodes(String s, int k) {
		double expectedSize = Math.pow(2, k);
		Set<String> set = new HashSet<>();
		for (int i = k; i <= s.length() && set.size() < expectedSize; i++) {
			set.add(s.substring(i - k, i));
		}
		return set.size() == expectedSize;
	}
	
}
