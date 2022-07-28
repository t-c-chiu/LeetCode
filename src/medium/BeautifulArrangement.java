package medium;

public class BeautifulArrangement {
	
	public static void main(String[] args) {
		int res = countArrangement(2);
		System.out.println(res);
	}
	
	static int res;
	
	public static int countArrangement(int n) {
		helper(1, n, new boolean[n + 1]);
		return res;
	}
	
	private static void helper(int pos, int n, boolean[] used) {
		if (pos > n) {
			res++;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!used[i] && (pos % i == 0 || i % pos == 0)) {
				used[i] = true;
				helper(pos + 1, n, used);
				used[i] = false;
			}
		}
	}
}
