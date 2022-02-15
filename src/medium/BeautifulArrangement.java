package medium;

public class BeautifulArrangement {
	
	public static void main(String[] args) {
		int res = countArrangement(3);
		System.out.println(res);
	}
	
	static int res = 0;
	
	public static int countArrangement(int n) {
		backtrack(1, n, new boolean[n + 1]);
		return res;
	}
	
	private static void backtrack(int pos, int n, boolean[] used) {
		if (pos > n) {
			res++;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!used[i] && (pos % i == 0 || i % pos == 0)) {
				used[i] = true;
				backtrack(pos + 1, n, used);
				used[i] = false;
			}
		}
	}
}
