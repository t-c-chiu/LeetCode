package easy;

public class CheckIfTwoStringArraysAreEquivalent {
	
	public static void main(String[] args) {
		boolean res = arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"});
		System.out.println(res);
	}
	
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuilder sb1 = new StringBuilder();
		for (String s : word1) {
			sb1.append(s);
		}
		StringBuilder sb2 = new StringBuilder();
		for (String s : word2) {
			sb2.append(s);
		}
		return sb1.toString().equals(sb2.toString());
	}
}
