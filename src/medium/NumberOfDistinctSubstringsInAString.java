package medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctSubstringsInAString {
	
	public static void main(String[] args) {
		int res = countDistinct("aabbaba");
		System.out.println(res);
	}
	
	static class Node {
		Node[] children = new Node[26];
	}
	
	public static int countDistinct(String s) {
		Node root = new Node();
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			Node cur = root;
			for (int j = i; j < s.length(); j++) {
				int k = s.charAt(j) - 'a';
				if (cur.children[k] == null) {
					cur.children[k] = new Node();
					res++;
				}
				cur = cur.children[k];
			}
		}
		return res;
	}
//	public static int countDistinct(String s) {
//		Set<String> set = new HashSet<>();
//		for (int i = 0; i < s.length(); i++) {
//			StringBuilder builder = new StringBuilder();
//			for (int j = i; j < s.length(); j++) {
//				builder.append(s.charAt(j));
//				set.add(builder.toString());
//			}
//		}
//		return set.size();
//	}
}
