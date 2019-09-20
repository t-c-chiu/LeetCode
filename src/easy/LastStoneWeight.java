package easy;

import java.util.*;

public class LastStoneWeight {
	
	public static void main(String[] args) {
		LastStoneWeight test = new LastStoneWeight();
		System.out.println(test.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
	}
	
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int stone : stones) {
			queue.add(stone);
		}
		while (queue.size() > 1) {
			int bigStone = queue.poll();
			int smallStone = queue.poll();
			if (bigStone > smallStone)
				queue.add(bigStone - smallStone);
		}
		return queue.isEmpty() ? 0 : queue.poll();
	}
}
