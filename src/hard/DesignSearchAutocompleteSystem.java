package hard;

import java.util.*;

public class DesignSearchAutocompleteSystem {
	
	public static void main(String[] args) {
		AutocompleteSystem obj =
				new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"},
						new int[]{5, 3, 2, 2});
		obj.input('i'); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
		obj.input(' '); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
		obj.input('a'); // return []. There are no sentences that have prefix "i a".
		obj.input('#'); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
	}
	
	static class AutocompleteSystem {
		
		TrieNode root;
		StringBuilder input;
		
		public AutocompleteSystem(String[] sentences, int[] times) {
			root = new TrieNode();
			input = new StringBuilder();
			for (int i = 0; i < sentences.length; i++) {
				saveSentence(sentences[i], times[i]);
			}
		}
		
		private void saveSentence(String sentence, int time) {
			TrieNode cur = root;
			for (int j = 0; j < sentence.length(); j++) {
				char c = sentence.charAt(j);
				int k = c == ' ' ? 26 : c - 'a';
				if (cur.next[k] == null) {
					cur.next[k] = new TrieNode();
				}
				cur = cur.next[k];
				cur.count.put(sentence, cur.count.getOrDefault(sentence, 0) + time);
			}
		}
		
		public List<String> input(char c) {
			if (c == '#') {
				saveSentence(input.toString(), 1);
				input = new StringBuilder();
				return new ArrayList<>();
			} else {
				input.append(c);
				return searchHotSentences(input.toString());
			}
		}
		
		private List<String> searchHotSentences(String s) {
			TrieNode cur = root;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				int k = c == ' ' ? 26 : c - 'a';
				if (cur.next[k] == null) {
					return new ArrayList<>();
				}
				cur = cur.next[k];
			}
			PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) ->
					a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
			Map<String, Integer> count = cur.count;
			for (Map.Entry<String, Integer> entry : count.entrySet()) {
				pq.offer(entry);
				if (pq.size() > 3) {
					pq.poll();
				}
			}
			List<String> res = new ArrayList<>();
			while (!pq.isEmpty()) {
				res.add(0, pq.poll().getKey());
			}
			return res;
		}
		
		class TrieNode {
			TrieNode[] next = new TrieNode[27];
			Map<String, Integer> count = new HashMap<>();
		}
	}
}
