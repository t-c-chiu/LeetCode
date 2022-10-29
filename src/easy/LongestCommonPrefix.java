package easy;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		String res = longestCommonPrefix(new String[]{"flow", "flower", "flight"});
		System.out.println(res);
	}
	
	public static String longestCommonPrefix(String[] strs) {
		String res = strs[0];
		for (int i = 1; i < strs.length; i++) {
			res = prefix(res, strs[i]);
		}
		return res;
	}
	
	private static String prefix(String prefix, String str) {
		int i = 0, j = 0;
		StringBuilder sb = new StringBuilder();
		while (i < prefix.length() && j < str.length() && prefix.charAt(i) == str.charAt(j)) {
			sb.append(prefix.charAt(i));
			i++;
			j++;
		}
		return sb.toString();
	}
}
