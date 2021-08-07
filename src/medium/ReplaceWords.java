package medium;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
	
	public static void main(String[] args) {
		String res = replaceWords(Arrays.asList("a", "b", "c"), "aadsfasf absbs bbab cadsfafs");
		System.out.println(res);
	}
	
	public static String replaceWords(List<String> dictionary, String sentence) {
		TrieNode root = new TrieNode();
		for (String word : dictionary) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				int j = word.charAt(i) - 'a';
				if (cur.next[j] == null) {
					cur.next[j] = new TrieNode();
				}
				cur = cur.next[j];
			}
			cur.isWord = true;
		}
		
		String[] chars = sentence.split(" ");
		for (int i = 0; i < chars.length; i++) {
			String word = chars[i];
			TrieNode cur = root;
			for (int j = 0; j < word.length(); j++) {
				int k = word.charAt(j) - 'a';
				if (cur.next[k] == null) {
					break;
				}
				if (cur.next[k].isWord) {
					chars[i] = word.substring(0, j + 1);
					break;
				}
				cur = cur.next[k];
			}
		}
		
		return String.join(" ", chars);
	}
	
	static class TrieNode {
		boolean isWord;
		TrieNode[] next = new TrieNode[26];
	}
}
