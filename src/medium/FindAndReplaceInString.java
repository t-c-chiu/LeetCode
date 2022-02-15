package medium;

import java.util.TreeMap;

public class FindAndReplaceInString {
	
	public static void main(String[] args) {
		String res = findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"});
		System.out.println(res);
	}
	
	public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for (int i = 0; i < indices.length; i++) {
			treeMap.put(indices[i], i);
		}
		StringBuilder builder = new StringBuilder(s);
		for (int from : treeMap.descendingKeySet()) {
			int i = treeMap.get(from);
			String source = sources[i];
			String target = targets[i];
			int to = from + source.length();
			if (s.startsWith(source, from)) {
				builder.replace(from, to, target);
			}
		}
		return builder.toString();
	}
}
