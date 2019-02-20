package easy;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargestElementInAStream().new KthLargest(3, new int[]{4, 5, 8, 2});
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
		System.out.println(kthLargest.add(4));
	}

	class KthLargest {
		private int k;
		private PriorityQueue<Integer> queue;

		public KthLargest(int k, int[] nums) {
			this.k = k;
			queue = new PriorityQueue<>(k);
			for (int i : nums)
				add(i);
		}

		// 8 5 4 3 2
		// 8 5 5 4 3 2
		// 10 8 5 5 4 3 2
		// 10 9 8 5 5 4 3 2
		// 10 9 8 5 5 4 4 3 2
		public int add(int val) {
			if (queue.size() < k) {
				queue.add(val);
			} else if (queue.peek() < val) {
				queue.poll();
				queue.add(val);
			}
			return queue.peek();
		}
	}
}
