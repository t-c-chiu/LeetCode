package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class DesignHitCounter {
	
	public static void main(String[] args) {
		HitCounter hitCounter = new HitCounter();
		hitCounter.hit(1);       // hit at timestamp 1.
		hitCounter.hit(2);       // hit at timestamp 2.
		hitCounter.hit(3);       // hit at timestamp 3.
		int res = hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
		System.out.println(res);
		hitCounter.hit(300);     // hit at timestamp 300.
		res = hitCounter.getHits(300); // get hits at timestamp 300, return 4.
		System.out.println(res);
		res = hitCounter.getHits(301); // get hits at timestamp 301, return 3.
		System.out.println(res);
	}
	
	static class HitCounter {
		
		Queue<Integer> queue;
		
		public HitCounter() {
			queue = new LinkedList<>();
		}
		
		public void hit(int timestamp) {
			queue.offer(timestamp);
		}
		
		public int getHits(int timestamp) {
			while (!queue.isEmpty() && queue.peek() < timestamp - 299) {
				queue.poll();
			}
			return queue.size();
		}
	}
}
