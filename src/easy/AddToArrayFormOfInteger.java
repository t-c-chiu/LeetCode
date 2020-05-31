package easy;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
	public static void main(String[] args) {
		AddToArrayFormOfInteger addToArrayFormOfInteger = new AddToArrayFormOfInteger();
		System.out.println(addToArrayFormOfInteger.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
		System.out.println(addToArrayFormOfInteger.addToArrayForm(new int[]{2, 7, 4}, 181));
		System.out.println(addToArrayFormOfInteger.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
	}
	
	/**
	 * Input: A = [1,2,0,0], K = 34
	 * Output: [1,2,3,4]
	 * Explanation: 1200 + 34 = 1234
	 * <p>
	 * Input: A = [2,7,4], K = 181
	 * Output: [4,5,5]
	 * Explanation: 274 + 181 = 455
	 * <p>
	 * Input: A = [2,1,5], K = 806
	 * Output: [1,0,2,1]
	 * Explanation: 215 + 806 = 1021
	 * <p>
	 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
	 * Output: [1,0,0,0,0,0,0,0,0,0,0]
	 */
	public List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> res = new LinkedList<>();
		for (int i = A.length - 1; i >= 0; --i) {
			res.add(0, (A[i] + K) % 10);
			K = (A[i] + K) / 10;
		}
		while (K > 0) {
			res.add(0, K % 10);
			K /= 10;
		}
		return res;
	}
}
