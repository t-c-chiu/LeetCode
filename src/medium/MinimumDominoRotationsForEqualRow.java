package medium;

public class MinimumDominoRotationsForEqualRow {
	
	public static void main(String[] args) {
		int res = minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2});
		System.out.println(res);
	}
	
	public static int minDominoRotations(int[] tops, int[] bottoms) {
		int n = tops.length;
		int[] topCount = new int[7];
		int[] bottomCount = new int[7];
		int[] same = new int[7];
		for (int i = 0; i < n; i++) {
			int t = tops[i];
			int b = bottoms[i];
			topCount[t]++;
			bottomCount[b]++;
			if (t == b) {
				same[t]++;
			}
		}
		for (int i = 1; i <= 6; i++) {
			if (topCount[i] + bottomCount[i] - same[i] == n) {
				return n - Math.max(topCount[i], bottomCount[i]);
			}
		}
		return -1;
	}
}
