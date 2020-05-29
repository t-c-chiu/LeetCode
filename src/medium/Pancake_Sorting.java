package medium;

import java.util.ArrayList;
import java.util.List;

public class Pancake_Sorting {
	
	public static void main(String[] args) {
		Pancake_Sorting test = new Pancake_Sorting();
		test.pancakeSort(new int[]{3, 2, 4, 1}).forEach(System.out::print);
	}
	
	/**
	 * Reverse the largest integer to the head then reverse it to the end of the unsorted array.
	 * 4 2 3 1 -> 1 3 2 4 -> 3 1 2 4 -> 2 1 3 4 -> 1 2 3 4
	 */
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> res = new ArrayList<>();
		for (int i = A.length; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if (A[j] == i) {
					if (j != 0) {
						res.add(j + 1);
						reverse(A, j);
					}
					res.add(i);
					reverse(A, i - 1);
					break;
				}
			}
		}
		return res;
	}
	
	private void reverse(int[] A, int end) {
		for (int i = 0, j = end; i < j; i++, j--) {
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
	}
}
