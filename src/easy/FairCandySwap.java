package easy;

import java.util.Arrays;

public class FairCandySwap {
	
	public static void main(String[] args) {
		FairCandySwap test = new FairCandySwap();
		for (int i : test.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})) {
			System.out.print(i);
		}
		System.out.println();
		for (int i : test.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})) {
			System.out.print(i);
		}
	}
	
	public int[] fairCandySwap(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int sumA = 0, sumB = 0;
		for (int i : A)
			sumA += i;
		for (int i : B)
			sumB += i;
		int average = (sumA + sumB) / 2;
		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			int newSumA = sumA - A[i] + B[j];
			if (newSumA == average)
				return new int[]{A[i], B[j]};
			else if (newSumA > average)
				i++;
			else
				j++;
		}
		return null;
	}
}
