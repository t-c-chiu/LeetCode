package easy;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
	
	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(1, new int[]{});
		System.out.println(kthLargest.add(-3));
		System.out.println(kthLargest.add(-2));
		System.out.println(kthLargest.add(-4));
		System.out.println(kthLargest.add(0));
		System.out.println(kthLargest.add(4));
	}
	
	static class KthLargest {
		
		PriorityQueue<Integer> pq;
		int k;
		
		public KthLargest(int k, int[] nums) {
			this.k = k;
			pq = new PriorityQueue<>();
			for (int num : nums) {
				pq.offer(num);
				if (pq.size() > k) {
					pq.poll();
				}
			}
		}
		
		public int add(int val) {
			pq.add(val);
			if (pq.size() > k) {
				pq.poll();
			}
			return pq.peek();
		}
	}
}
