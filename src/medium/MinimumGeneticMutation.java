package medium;

import java.util.*;

public class MinimumGeneticMutation {
	
	public static void main(String[] args) {
		int res = minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
		System.out.println(res);
	}
	
	public static int minMutation(String start, String end, String[] bank) {
		Set<String> set = new HashSet<>(Arrays.asList(bank));
		if (!set.contains(end)) {
			return -1;
		}
		int res = 0;
		List<Character> list = Arrays.asList('A', 'C', 'G', 'T');
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				String gene = queue.poll();
				if (gene.equals(end)){
					return res;
				}
				char[] chars = gene.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char oldGene = chars[j];
					for (Character c : list) {
						if (chars[j] != c) {
							chars[j] = c;
							String next = String.valueOf(chars);
							if (set.contains(next)) {
								set.remove(next);
								queue.offer(next);
							}
						}
					}
					chars[j] = oldGene;
				}
			}
			res++;
		}
		return -1;
	}
}
