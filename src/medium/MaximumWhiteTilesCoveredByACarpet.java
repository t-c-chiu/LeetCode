package medium;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumWhiteTilesCoveredByACarpet {
	
	public static void main(String[] args) {
		int res = maximumWhiteTiles(new int[][]{{1, 1}, {10, 11}}, 2);
		System.out.println(res);
	}
	
	public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
		Arrays.sort(tiles, Comparator.comparingInt(tile -> tile[0]));
		int n = tiles.length, res = 0;
		int[] preSum = new int[n];
		for (int i = 0; i < n; i++) {
			if (i > 0) {
				preSum[i] = preSum[i - 1];
			}
			preSum[i] += tiles[i][1] - tiles[i][0] + 1;
		}
		for (int i = 0; i < n; i++) {
			int end = tiles[i][0] + carpetLen - 1, lo = i, hi = n - 1, last = 0;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (tiles[mid][0] > end) {
					hi = mid - 1;
				} else {
					last = mid;
					lo = mid + 1;
				}
			}
			int cover = last == 0 ? 0 : i == 0 ? preSum[last - 1] : preSum[last - 1] - preSum[i - 1];
			int partialCover = Math.min(end, tiles[last][1]) - tiles[last][0] + 1;
			res = Math.max(res, cover + partialCover);
		}
		return res;
	}
//	public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
//		Arrays.sort(tiles, Comparator.comparingInt(tile -> tile[0]));
//		int l = 0, r = 0, n = tiles.length, res = 0, cover = 0;
//		while (r < n && res < carpetLen) {
//			int[] leftTile = tiles[l], rightTile = tiles[r];
//			if (leftTile[0] + carpetLen > rightTile[1]) {
//				cover += rightTile[1] - rightTile[0] + 1;
//				res = Math.max(res, cover);
//				r++;
//			} else {
//				int partialCover = Math.max(0, leftTile[0] + carpetLen - rightTile[0]);
//				res = Math.max(res, cover + partialCover);
//				cover -= leftTile[1] - leftTile[0] + 1;
//				l++;
//			}
//		}
//		return res;
//	}
}
