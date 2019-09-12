package easy;

import java.util.Arrays;

public class AssignCookies {
	
	public static void main(String[] args) {
		AssignCookies test = new AssignCookies();
		int ans = test.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
		System.out.println(ans);
		
		ans = test.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
		System.out.println(ans);
	}
	
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int res = 0, childIndex = 0, cookieIndex = 0;
		while (cookieIndex < s.length && childIndex < g.length) {
			if (s[cookieIndex] >= g[childIndex]) {
				res++;
				childIndex++;
			}
			cookieIndex++;
		}
		return res;
	}
}
