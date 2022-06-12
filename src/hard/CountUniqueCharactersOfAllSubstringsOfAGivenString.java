package hard;

import java.util.*;

public class CountUniqueCharactersOfAllSubstringsOfAGivenString {
	
	public static void main(String[] args) {
		int res = uniqueLetterString("ABCA");
		System.out.println(res);
	}
	
	public static int uniqueLetterString(String s) {
		int[][] index = new int[26][2];
		for (int i = 0; i < index.length; i++) {
			Arrays.fill(index[i], -1);
		}
		int n = s.length();
		int res = 0;
		for (int i = 0; i < n; i++) {
			int j = s.charAt(i) - 'A';
			res += (i - index[j][1]) * (index[j][1] - index[j][0]);
			index[j] = new int[]{index[j][1], i};
		}
		for (int i = 0; i < index.length; i++) {
			res += (n - index[i][1]) * (index[i][1] - index[i][0]);
		}
		return res;
	}
	
//	public static int uniqueLetterString(String s) {
//		int res = 0, n = s.length();
//		Map<Character, List<Integer>> map = new HashMap<>();
//		for (int i = 0; i < n; i++) {
//			char c = s.charAt(i);
//			map.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
//		}
//		for (List<Integer> list : map.values()) {
//			for (int i = 0; i < list.size(); i++) {
//				int left = i == 0 ? list.get(i) + 1 : list.get(i) - list.get(i - 1);
//				int right = i == list.size() - 1 ? n - list.get(i) : list.get(i + 1) - list.get(i);
//				res += left * right;
//			}
//		}
//		return res;
//	}
}
