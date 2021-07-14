package medium;

public class UniqueLength3PalindromicSubsequences {
	
	public static void main(String[] args) {
		int res = countPalindromicSubsequence("aabca");
		System.out.println(res);
	}
	
	public static int countPalindromicSubsequence(String s) {
		int n = s.length();
		boolean[] visited = new boolean[26];
		int res = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (visited[c - 'a']) {
				continue;
			}
			for (int j = n - 1; j > i; j--) {
				if (c == s.charAt(j)) {
					boolean[] counted = new boolean[26];
					for (int k = i + 1; k < j; k++) {
						char midChar = s.charAt(k);
						if (counted[midChar - 'a']) {
							continue;
						}
						res++;
						counted[midChar - 'a'] = true;
					}
					break;
				}
			}
			visited[c - 'a'] = true;
		}
		return res;
	}
}
