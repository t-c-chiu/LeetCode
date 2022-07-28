package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
	
	public static void main(String[] args) {
		List<List<String>> res = suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
		System.out.println(res);
	}
	
	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);
		TrieNode root = new TrieNode();
		for (String product : products) {
			TrieNode cur = root;
			for (int i = 0; i < product.length(); i++) {
				int j = product.charAt(i) - 'a';
				if (cur.next[j] == null) {
					cur.next[j] = new TrieNode();
				}
				cur = cur.next[j];
				if (cur.suggested.size() < 3) {
					cur.suggested.add(product);
				}
			}
		}
		List<List<String>> res = new ArrayList<>();
		TrieNode cur = root;
		for (int i = 0; i < searchWord.length(); i++) {
			int j = searchWord.charAt(i) - 'a';
			if (cur.next[j] == null) {
				break;
			}
			cur = cur.next[j];
			res.add(cur.suggested);
		}
		while (res.size() < searchWord.length()) {
			res.add(new ArrayList<>());
		}
		return res;
	}
	
	static class TrieNode {
		TrieNode[] next;
		List<String> suggested;
		
		TrieNode() {
			next = new TrieNode[26];
			suggested = new ArrayList<>();
		}
	}
}
