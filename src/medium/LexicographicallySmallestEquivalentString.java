package medium;

public class LexicographicallySmallestEquivalentString {
	
	public static void main(String[] args) {
		String res = smallestEquivalentString("parker", "morris", "parser");
		System.out.println(res);
	}
	
	public static String smallestEquivalentString(String s1, String s2, String baseStr) {
		int n = s1.length();
		int[] parent = new int[26];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < n; i++) {
			int p1 = find(parent, s1.charAt(i) - 'a');
			int p2 = find(parent, s2.charAt(i) - 'a');
			merge(parent, p1, p2);
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < baseStr.length(); i++) {
			builder.append((char) (find(parent, baseStr.charAt(i) - 'a') + 'a'));
		}
		return builder.toString();
	}
	
	private static int find(int[] parent, int i) {
		if (parent[i] != i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}
	
	private static void merge(int[] parent, int p1, int p2) {
		parent[Math.max(p1, p2)] = Math.min(p1, p2);
	}
	
}
