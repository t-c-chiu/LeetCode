package easy;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {
	
	public static void main(String[] args) {
		int[] res = new SumOfEvenNumbersAfterQueries()
				.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}});
		Arrays.stream(res).forEach(System.out::println);
	}
	
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] result = new int[queries.length];
		int sum = 0;
		for (int i : A) {
			if (i % 2 == 0)
				sum += i;
		}
		for (int i = 0; i < queries.length; i++) {
			int index = queries[i][1], prevNum = A[index];
			if (prevNum % 2 == 0)
				sum -= prevNum;
			int num = A[index] += queries[i][0];
			if (num % 2 == 0)
				sum += num;
			result[i] = sum;
		}
		return result;
	}
}
