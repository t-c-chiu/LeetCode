package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
	
	public static void main(String[] args) {
		RevealCardsInIncreasingOrder test = new RevealCardsInIncreasingOrder();
		final int[] res = test.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i : res)
			queue.add(i);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
			if (!queue.isEmpty())
				queue.offer(queue.poll());
		}
	}
	
	public int[] deckRevealedIncreasing(int[] deck) {
		int len = deck.length;
		int[] res = new int[len];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < len; i++)
			queue.add(i);
		Arrays.sort(deck);
		for (int i = 0; i < len; i++) {
			res[queue.poll()] = deck[i];
			queue.offer(queue.poll());
		}
		return res;
	}
}
