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
		int res = 1;
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				String word = queue.poll();
				if (word.equals(endWord)) {
					return res;
				}
				char[] chars = word.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char c = chars[j];
					for (char k = 'a'; k <= 'z'; k++) {
						if (c != k) {
							chars[j] = k;
							String next = String.valueOf(chars);
							if (set.contains(next)) {
								set.remove(next);
								queue.offer(next);
							}
						}
					}
					chars[j] = c;
				}
			}
			res++;
		}
		return 0;
	}
}
