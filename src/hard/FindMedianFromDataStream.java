package hard;

import java.util.*;

public class FindMedianFromDataStream {
	
	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
	}
	
	
	static class MedianFinder {
		
		PriorityQueue<Integer> small;
		PriorityQueue<Integer> big;
		
		public MedianFinder() {
			small = new PriorityQueue<>();
			big = new PriorityQueue<>(Comparator.reverseOrder());
		}
		
		public void addNum(int num) {
			if (small.size() == big.size()) {
				big.offer(num);
				small.offer(big.poll());
			} else {
				small.offer(num);
				big.offer(small.poll());
			}
		}
		
		public double findMedian() {
			return small.size() == big.size() ? (small.peek() + big.peek()) / 2d : small.peek();
		}
	}
}
