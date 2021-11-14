package medium;

public class LexicographicallySmallestEquivalentString {
	
	public static void main(String[] args) {
		String res = smallestEquivalentString("parker", "morris", "parser");
		System.out.println(res);
	}
	
	public static String smallestEquivalentString(String s1, String s2, String baseStr) {
		int[] graph = new int[26];
		for (int i = 0; i < 26; i++) {
			graph[i] = i;
		}
		
		for (int i = 0; i < s1.length(); i++) {
			merge(graph, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < baseStr.length(); i++) {
			builder.append((char) ('a' + find(graph, baseStr.charAt(i) - 'a')));
		}
		return builder.toString();
	}
	
	private static void merge(int[] graph, int i, int j) {
		int p1 = find(graph, i), p2 = find(graph, j);
		if (p1 < p2) {
			graph[p2] = p1;
		} else {
			graph[p1] = p2;
		}
	}
	
	private static int find(int[] graph, int i) {
		if (graph[i] != i) {
			i = find(graph, graph[i]);
		}
		return i;
	}
}
