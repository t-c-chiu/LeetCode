package hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
	public static void main(String[] args) {
		List<String> res = fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
		for (String re : res) {
			System.out.println("[" + re + "]");
		}
	}
	
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		int len = words[0].length();
		int start = 0;
		for (int i = 0; i < words.length - 1; i++) {
			len += words[i + 1].length() + 1;
			if (len > maxWidth) {
				res.add(justyfy(words, start, i, maxWidth));
				start = i + 1;
				len = words[i + 1].length();
			}
		}
		res.add(justyfyLastLine(words, start, words.length - 1, maxWidth));
		return res;
	}
	
	private static String justyfy(String[] words, int start, int end, int maxWidth) {
		int spaceCount = end - start;
		int wordsLen = 0;
		for (int i = start; i <= end; i++) {
			wordsLen += words[i].length();
		}
		int spaceLength = maxWidth - wordsLen;
		StringBuilder builder = new StringBuilder();
		for (int i = start; i <= end; i++) {
			builder.append(words[i]);
			if (i < end) {
				builder.append(createSpace(spaceLength / spaceCount, spaceLength % spaceCount, i - start));
			}
		}
		addSpaces(builder, maxWidth);
		return builder.toString();
	}
	
	private static String createSpace(int spaceLength, int oneMoreSpaceIdx, int i) {
		StringBuilder builder = new StringBuilder();
		for (int j = 0; j < spaceLength; j++) {
			builder.append(" ");
		}
		if (i < oneMoreSpaceIdx) {
			builder.append(" ");
		}
		return builder.toString();
	}
	
	
	private static String justyfyLastLine(String[] words, int start, int end, int maxWidth) {
		StringBuilder builder = new StringBuilder();
		for (int i = start; i <= end; i++) {
			builder.append(words[i]);
			if (builder.length() < maxWidth) {
				builder.append(" ");
			}
		}
		addSpaces(builder, maxWidth);
		return builder.toString();
	}
	
	private static void addSpaces(StringBuilder builder, int maxWidth) {
		for (int i = builder.length(); i < maxWidth; i++) {
			builder.append(" ");
		}
	}
}
