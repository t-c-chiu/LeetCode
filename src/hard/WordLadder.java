package hard;

import java.util.*;

public class WordLadder {
	
	public static void main(String[] args) {
		int res = ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		System.out.println(res);
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		if (!set.contains(endWord)) {
			return 0;
		}
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		int res = 1;
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				String word = q.poll();
				if (word.equals(endWord)) {
					return res;
				}
				for (int j = 0; j < word.length(); j++) {
					for (char k = 'a'; k <= 'z'; k++) {
						char[] chars = word.toCharArray();
						chars[j] = k;
						String next = new String(chars);
						if (set.contains(next)) {
							q.offer(next);
							set.remove(next);
						}
					}
				}
			}
			res++;
		}
		return 0;
	}
}
