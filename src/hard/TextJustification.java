package hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
	public static void main(String[] args) {
		List<String> res = fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
		for (String re : res) {
			System.out.println("[" + re + "]");
		}
	}
	
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		int start = 0, n = words.length;
		while (start < n) {
			int i = start, len = words[i].length();
			while (i + 1 < n) {
				if (len + words[i + 1].length() + 1 > maxWidth) {
					add(res, words, start, i, maxWidth);
					start = i + 1;
					break;
				} else {
					len += words[i + 1].length() + 1;
					i++;
				}
			}
			if (i == n - 1) {
				break;
			}
		}
		addLast(res, words, start, maxWidth);
		return res;
	}
	
	private static void add(List<String> res, String[] words, int start, int end, int maxWith) {
		int count = end - start, len = 0;
		if (count == 0) {
			addOne(res, words, start, maxWith);
			return;
		}
		for (int i = start; i <= end; i++) {
			len += words[i].length();
		}
		int space = maxWith - len;
		StringBuilder builder = new StringBuilder();
		for (int i = start; i <= end; i++) {
			builder.append(words[i]);
			if (i < end) {
				builder.append(getSpace(space / count, space % count, i - start));
			}
		}
		res.add(builder.toString());
	}
	
	private static void addOne(List<String> res, String[] words, int i, int maxWith) {
		StringBuilder builder = new StringBuilder(words[i]);
		builder.append(" ".repeat(maxWith - builder.length()));
		res.add(builder.toString());
	}
	
	private static StringBuilder getSpace(int count, int addOne, int i) {
		StringBuilder builder = new StringBuilder();
		for (int j = 0; j < count; j++) {
			builder.append(" ");
		}
		if (i < addOne) {
			builder.append(" ");
		}
		return builder;
	}
	
	private static void addLast(List<String> res, String[] words, int start, int maxWith) {
		StringBuilder builder = new StringBuilder();
		for (int i = start; i < words.length; i++) {
			builder.append(words[i]);
			if (builder.length() < maxWith) {
				builder.append(" ");
			}
		}
		builder.append(" ".repeat(maxWith - builder.length()));
		res.add(builder.toString());
	}
	
}
