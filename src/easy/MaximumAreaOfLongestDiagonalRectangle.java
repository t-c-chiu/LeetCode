package easy;

public class MaximumAreaOfLongestDiagonalRectangle {
	
	public static void main(String[] args) {
	
	}
	
	public static int areaOfMaxDiagonal(int[][] dimensions) {
		int res = 0, maxDia = 0;
		for (int[] dimension : dimensions) {
			int x = dimension[0], y = dimension[1], dia = x * x + y * y;
			if (dia > maxDia || dia == maxDia && x * y > res) {
				maxDia = dia;
				res = x * y;
			}
		}
		return res;
	}
	
}
