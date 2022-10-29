package medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	
	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}
	
	public static List<Integer> partitionLabels(String s) {
		int n = s.length();
		List<Integer> res = new ArrayList<>();
		int[] lastIndex = new int[26];
		for (int i = 0; i < n; i++) {
			lastIndex[s.charAt(i) - 'a'] = i;
		}
		int last = -1, max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, lastIndex[s.charAt(i) - 'a']);
			if (max == i) {
				res.add(i - last);
				last = i;
			}
		}
		return res;
	}
}
