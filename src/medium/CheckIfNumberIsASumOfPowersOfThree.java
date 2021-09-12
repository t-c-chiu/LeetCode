package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CheckIfNumberIsASumOfPowersOfThree {
	
	public static void main(String[] args) {
		boolean res = checkPowersOfThree(91);
		System.out.println(res);
	}
	
	public static boolean checkPowersOfThree(int n) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int num = 1;
		while (num <= n) {
			pq.offer(num);
			num *= 3;
		}
		
		while (!pq.isEmpty() && n > 0) {
			Integer i = pq.poll();
			if (i <= n) {
				n -= i;
			}
		}
		return n == 0;
	}
}
