package easy;

import java.util.Arrays;

public class SquaresOfASortedArray {
	
	public static void main(String[] args) {
		SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
		System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
		System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
	}
	
	public int[] sortedSquares(int[] A) {
		int length = A.length;
		int[] res = new int[length];
		int i = 0, j = length - 1;
		for (int p = j; p >= 0; p--) {
			int absi = Math.abs(A[i]), absj = Math.abs(A[j]);
			if (absi > absj) {
				res[p] = absi * absi;
				i++;
			} else {
				res[p] = absj * absj;
				j--;
			}
		}
		return res;
	}
}
