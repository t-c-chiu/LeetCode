package easy;

public class RangeAdditionII {
	
	public static void main(String[] args) {
		int res = maxCount(3, 3, new int[][]{{2, 2}, {3, 3}});
		System.out.println(res);
	}
	
	public static int maxCount(int m, int n, int[][] ops) {
		for (int[] op : ops) {
			m = Math.min(m, op[0]);
			n = Math.min(n, op[1]);
		}
		return m * n;
	}
}
