package easy;

import java.util.*;

public class Letter_Case_Permutation {
	
	public static void main(String[] args) {
		Letter_Case_Permutation test = new Letter_Case_Permutation();
		System.out.println(test.letterCasePermutation2("a1b2"));
		System.out.println(test.letterCasePermutation("3z4"));
		System.out.println(test.letterCasePermutation("12345"));
	}
	
	public List<String> letterCasePermutation(String S) {
		if (S.isEmpty())
			return new ArrayList<>();
		List<String> list = new ArrayList<>();
		helper(S.toCharArray(), list, 0);
		return list;
	}
	
	private void helper(char[] chars, List<String> list, int pos) {
		if (chars.length == pos) {
			list.add(String.valueOf(chars));
			return;
		}
		if (Character.isLetter(chars[pos])) {
			chars[pos] = Character.toLowerCase(chars[pos]);
			helper(chars, list, pos + 1);
			chars[pos] = Character.toUpperCase(chars[pos]);
			helper(chars, list, pos + 1);
		} else
			helper(chars, list, pos + 1);
	}
	
	public List<String> letterCasePermutation2(String S) {
		if (S.isEmpty())
			return new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(S);
		for (int i = 0; i < S.length(); i++) {
			if (Character.isDigit(S.charAt(i)))
				continue;
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				char[] chars = queue.poll().toCharArray();
				chars[i] = Character.toLowerCase(chars[i]);
				queue.offer(String.valueOf(chars));
				chars[i] = Character.toUpperCase(chars[i]);
				queue.offer(String.valueOf(chars));
			}
		}
		return new ArrayList<>(queue);
	}
}
