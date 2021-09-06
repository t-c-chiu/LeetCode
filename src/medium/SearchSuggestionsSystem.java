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
		List<List<String>> res = new ArrayList<>();
		Arrays.sort(products);
		TrieNode root = new TrieNode();
		for (String product : products) {
			buildTrie(root, product);
		}
		
		TrieNode cur = root;
		for (int i = 0; i < searchWord.length(); i++) {
			int j = searchWord.charAt(i) - 'a';
			TrieNode next = cur.next[j];
			if (next == null) {
				break;
			}
			res.add(next.suggested);
			cur = next;
		}
		
		for (int i = res.size(); i < searchWord.length(); i++) {
			res.add(new ArrayList<>());
		}
		return res;
	}
	
	private static void buildTrie(TrieNode root, String product) {
		TrieNode cur = root;
		for (int i = 0; i < product.length(); i++) {
			char c = product.charAt(i);
			int j = c - 'a';
			if (cur.next[j] == null) {
				cur.next[j] = new TrieNode();
			}
			TrieNode next = cur.next[j];
			if (next.suggested.size() < 3) {
				next.suggested.add(product);
			}
			cur = next;
		}
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
