package hard;

import java.util.*;

public class WordLadderII {
	
	public static void main(String[] args) {
		List<List<String>> res = findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		System.out.println(res);
	}
	
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		Set<String> set = new HashSet<>(wordList);
		if (!set.contains(endWord)) {
			return res;
		}
		Queue<List<String>> q = new LinkedList<>();
		q.offer(Arrays.asList(beginWord));
		Set<String> seen = new HashSet<>();
		seen.add(beginWord);
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				List<String> path = q.poll();
				String lastWord = path.get(path.size() - 1);
				for (int j = 0; j < lastWord.length(); j++) {
					char[] chars = lastWord.toCharArray();
					for (char k = 'a'; k <= 'z'; k++) {
						chars[j] = k;
						String next = new String(chars);
						if (set.contains(next)) {
							seen.add(next);
							List<String> newPath = new ArrayList<>(path);
							newPath.add(next);
							if (next.equals(endWord)) {
								res.add(newPath);
							} else {
								q.offer(newPath);
							}
						}
					}
				}
			}
			for (String s : seen) {
				set.remove(s);
			}
			seen.clear();
		}
		return res;
	}
	
}
