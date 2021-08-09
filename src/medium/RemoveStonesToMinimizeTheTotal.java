package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
	
	public static void main(String[] args) {
		int res = minStoneSum(new int[]{5, 4, 9}, 2);
		System.out.println(res);
	}
	
	public static int minStoneSum(int[] piles, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		int res = 0;
		for (int pile : piles) {
			queue.offer(pile);
			res += pile;
		}
		while (k > 0) {
			int pile = queue.poll();
			int removed = pile / 2;
			pile -= removed;
			res -= removed;
			queue.offer(pile);
			k--;
		}
		return res;
	}
}
