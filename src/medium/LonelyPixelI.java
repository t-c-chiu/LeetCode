package medium;

public class LonelyPixelI {
	
	public static void main(String[] args) {
		int res = findLonelyPixel(new char[][]{
				new char[]{'W', 'B', 'W', 'W'},
				new char[]{'W', 'B', 'B', 'W'},
				new char[]{'W', 'W', 'W', 'W'},
		});
		System.out.println(res);
	}
	
	public static int findLonelyPixel(char[][] picture) {
		int m = picture.length, n = picture[0].length, res = 0;
		int[] colCount = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] == 'B') {
					colCount[j]++;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			int rowCount = 0, col = 0;
			for (int j = 0; j < n; j++) {
				if (picture[i][j] == 'B') {
					rowCount++;
					col = j;
				}
			}
			if (rowCount == 1 && colCount[col] == 1) {
				res++;
			}
		}
		return res;
	}
	
}
