package hard;

import java.util.Arrays;

public class CountUniqueCharactersOfAllSubstringsOfAGivenString {
	
	public static void main(String[] args) {
		int res = uniqueLetterString("LEETCODE");
		System.out.println(res);
	}
	
	public static int uniqueLetterString(String s) {
		int res = 0, n = s.length();
		// [i][0] = lastlast, [i][1]= last;
		int[][] last = new int[26][2];
		Arrays.fill(last, new int[]{-1, -1});
		for (int i = 0; i < n; i++) {
			int j = s.charAt(i) - 'A';
			int prev = last[j][0];
			int cur = last[j][1];
			res += (cur - prev) * (i - cur);
			last[j] = new int[]{cur, i};
		}
		for (int[] info : last) {
			int prev = info[0];
			int cur = info[1];
			res += (cur - prev) * (n - cur);
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
