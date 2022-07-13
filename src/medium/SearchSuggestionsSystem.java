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
		for (int i = 0; i < searchWord.length(); i++) {
			int j = searchWord.charAt(i) - 'a';
			if (root.next[j] == null) {
				break;
			} else {
				res.add(root.next[j].suggested);
				root = root.next[j];
			}
		}
		for (int i = res.size(); i < searchWord.length(); i++) {
			res.add(new ArrayList<>());
		}
		return res;
	}
	
	private static void buildTrie(TrieNode root, String product) {
		TrieNode cur = root;
		for (int i = 0; i < product.length(); i++) {
			int j = product.charAt(i) - 'a';
			if (cur.next[j] == null) {
				cur.next[j] = new TrieNode();
			}
			if (cur.next[j].suggested.size() < 3) {
				cur.next[j].suggested.add(product);
			}
			cur = cur.next[j];
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
