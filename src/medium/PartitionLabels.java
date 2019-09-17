package medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	
	public static void main(String[] args) {
		PartitionLabels test = new PartitionLabels();
		System.out.println(test.partitionLabels("ababcbacadefegdehijhklij"));
	}
	
	public List<Integer> partitionLabels(String S) {
		List<Integer> res = new ArrayList<>();
		int[] lastIndex = new int[26];
		for (int i = 0; i < S.length(); i++) {
			lastIndex[S.charAt(i) - 'a'] = i;
		}
		int start = 0, last = 0;
		for (int i = 0; i < S.length(); i++) {
			last = Math.max(last, lastIndex[S.charAt(i) - 'a']);
			if (i == last) {
				res.add(last - start + 1);
				start = last + 1;
			}
		}
		return res;
	}
}
