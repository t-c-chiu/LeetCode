package hard;

import java.util.*;

public class FindMedianFromDataStream {
	
	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addAndPrint(-1);
		medianFinder.addAndPrint(-2);
		medianFinder.addAndPrint(-3);
		medianFinder.addAndPrint(-4);
		medianFinder.addAndPrint(-5);
	}
	
	
	static class MedianFinder {
		
		PriorityQueue<Integer> small;
		PriorityQueue<Integer> big;
		
		public MedianFinder() {
			small = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
			big = new PriorityQueue<>();
		}
		
		public double findMedian() {
			return small.size() == big.size() ? (small.peek() + big.peek()) / 2d : small.peek();
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
		
		public void addAndPrint(int num) {
			addNum(num);
			System.out.println("add " + num + " median: " + findMedian());
		}
	}
}
