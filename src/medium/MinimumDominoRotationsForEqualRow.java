package medium;

public class MinimumDominoRotationsForEqualRow {
	
	public static void main(String[] args) {
		int res = minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2});
		System.out.println(res);
	}
	
	public static int minDominoRotations(int[] tops, int[] bottoms) {
		int n = tops.length;
		for (int i = 0, target = tops[0], flipT = 0, flipB = 0; i < n && (tops[i] == target || bottoms[i] == target); i++) {
			if (tops[i] != target) {
				flipT++;
			}
			if (bottoms[i] != target) {
				flipB++;
			}
			if (i == n - 1) {
				return Math.min(flipT, flipB);
			}
		}
		for (int i = 0, target = bottoms[0], flipT = 0, flipB = 0; i < n && (tops[i] == target || bottoms[i] == target); i++) {
			if (tops[i] != target) {
				flipT++;
			}
			if (bottoms[i] != target) {
				flipB++;
			}
			if (i == n - 1) {
				return Math.min(flipT, flipB);
			}
		}
		return -1;
	}

//	public static int minDominoRotations(int[] tops, int[] bottoms) {
//		int[] tc = new int[7];
//		int[] bc = new int[7];
//		int[] same = new int[7];
//		int n = tops.length;
//		for (int i = 0; i < n; i++) {
//			int top = tops[i];
//			int bottom = bottoms[i];
//			tc[top]++;
//			bc[bottom]++;
//			if (top == bottom) {
//				same[top]++;
//			}
//		}
//		for (int i = 1; i <= 6; i++) {
//			if (tc[i] + bc[i] - same[i] == n) {
//				return n - Math.max(tc[i], bc[i]);
//			}
//		}
//		return -1;
//	}
}
