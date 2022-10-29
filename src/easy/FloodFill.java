package easy;

public class FloodFill {
	
	public static void main(String[] args) {
	
	}
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int oldColor = image[sr][sc];
		if (oldColor == color) {
			return image;
		}
		dfs(image, sr, sc, oldColor, color);
		return image;
	}
	
	private static void dfs(int[][] image, int i, int j, int oldColor, int color) {
		if (i < 0 || i == image.length || j < 0 || j == image[0].length || image[i][j] != oldColor) {
			return;
		}
		image[i][j] = color;
		dfs(image, i + 1, j, oldColor, color);
		dfs(image, i - 1, j, oldColor, color);
		dfs(image, i, j + 1, oldColor, color);
		dfs(image, i, j - 1, oldColor, color);
	}
}
