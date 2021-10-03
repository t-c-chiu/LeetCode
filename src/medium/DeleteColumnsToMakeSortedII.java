package medium;

public class DeleteColumnsToMakeSortedII {
	
	public static void main(String[] args) {
		int res = minDeletionSize(new String[]{"xga","xfb","yfa"});
		System.out.println(res);
	}
	
	/**
	 * "jsebodtwc","cnneoytml","eeneuyzlu","ewpnmtivg"
	 */
	public static int minDeletionSize(String[] strs) {
		int res = 0, m = strs[0].length(), n = strs.length, j;
		boolean[] sorted = new boolean[n - 1];
		for (int i = 0; i < m; i++) {
			for (j = 0; j < n - 1; j++) {
				if (!sorted[j] && strs[j].charAt(i) > strs[j + 1].charAt(i)) {
					res++;
					break;
				}
			}
			if (j < n - 1) {
				continue;
			}
			for (j = 0; j < n - 1; j++) {
				if (!sorted[j]) {
					sorted[j] = strs[j].charAt(i) < strs[j + 1].charAt(i);
				}
			}
		}
		return res;
	}
}
