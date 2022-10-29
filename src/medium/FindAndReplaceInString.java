package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindAndReplaceInString {
	
	public static void main(String[] args) {
		String res = findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"});
		System.out.println(res);
	}
	
	public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
		StringBuilder builder = new StringBuilder(s);
		List<Replacement> list = new ArrayList<>();
		for (int i = 0; i < indices.length; i++) {
			list.add(new Replacement(indices[i], sources[i], targets[i]));
		}
		list.sort(Comparator.comparingInt(replacement -> -replacement.index));
		for (Replacement replacement : list) {
			int index = replacement.index;
			String source = replacement.source;
			String target = replacement.target;
			if (s.startsWith(source, index)) {
				builder.replace(index, index + source.length(), target);
			}
		}
		return builder.toString();
	}
	
	static class Replacement {
		int index;
		String source;
		String target;
		
		public Replacement(int index, String source, String target) {
			this.index = index;
			this.source = source;
			this.target = target;
		}
	}
}
