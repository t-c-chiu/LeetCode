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
		private PriorityQueue<Integer> small;
		private PriorityQueue<Integer> large;
		private boolean even;
		
		public MedianFinder() {
			small = new PriorityQueue<>(Comparator.reverseOrder());
			large = new PriorityQueue<>();
			even = true;
		}
		
		public double findMedian() {
			if (even)
				return (small.peek() + large.peek()) / 2.0;
			else
				return small.peek();
		}
		
		public void addNum(int num) {
			if (even) {
				large.offer(num);
				small.offer(large.poll());
			} else {
				small.offer(num);
				large.offer(small.poll());
			}
			even = !even;
		}
		
		public void addAndPrint(int num) {
			addNum(num);
			System.out.println("add " + num + " median: " + findMedian());
		}
	}
}
