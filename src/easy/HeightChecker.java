package easy;

public class HeightChecker {
	
	public static void main(String[] args) {
		int res = heightChecker(new int[]{1, 1, 4, 2, 1, 3});
		System.out.println(res);
	}
	
	public static int heightChecker(int[] heights) {
		int n = heights.length, res = 0;
		int[] count = new int[101];
		for (int height : heights) {
			count[height]++;
		}
		int curHeight = 1;
		for (int i = 0; i < n; i++) {
			while (count[curHeight] == 0) {
				curHeight++;
			}
			if (curHeight != heights[i]) {
				res++;
			}
			count[curHeight]--;
		}
		return res;
	}
}
