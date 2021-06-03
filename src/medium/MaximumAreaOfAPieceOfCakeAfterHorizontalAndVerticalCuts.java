package medium;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
	
	public static void main(String[] args) {
		int res = maxArea(5, 4, new int[]{3, 1}, new int[]{1});
		System.out.println(res);
	}
	
	
	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		int hLen = horizontalCuts.length;
		int vLen = verticalCuts.length;
		
		long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[hLen - 1]);
		for (int i = 1; i < hLen; i++) {
			maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
		}
		
		long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[vLen - 1]);
		for (int i = 1; i < vLen; i++) {
			maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
		}
		return (int) ((maxHeight * maxWidth) % (1e9 + 7));
	}
	
}
