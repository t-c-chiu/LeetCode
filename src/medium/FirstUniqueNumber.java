package medium;

import java.util.*;

public class FirstUniqueNumber {
	
	public static void main(String[] args) {
		FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
		firstUnique.showFirstUnique(); // return 2
		firstUnique.add(5);            // the queue is now [2,3,5,5]
		firstUnique.showFirstUnique(); // return 2
		firstUnique.add(2);            // the queue is now [2,3,5,5,2]
		firstUnique.showFirstUnique(); // return 3
		firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
		firstUnique.showFirstUnique(); // return -1
	}
	
	static class FirstUnique {
		
		Map<Integer, Node> seen;
		Node head;
		Node tail;
		
		public FirstUnique(int[] nums) {
			seen = new HashMap<>();
			head = new Node(0);
			tail = new Node(0);
			head.next = tail;
			tail.prev = head;
			for (int num : nums) {
				add(num);
			}
		}
		
		public int showFirstUnique() {
			return head.next == tail ? -1 : head.next.val;
		}
		
		public void add(int value) {
			if (seen.containsKey(value)) {
				remove(seen.get(value));
			} else {
				Node node = new Node(value);
				addToTail(node);
				seen.put(value, node);
			}
		}
		
		private void addToTail(Node node) {
			node.prev = tail.prev;
			node.next = tail;
			tail.prev.next = node;
			tail.prev = node;
		}
		
		private void remove(Node node) {
			if (node.prev == null || node.next == null) {
				return;
			}
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.prev = null;
			node.next = null;
		}
		
		class Node {
			int val;
			Node prev;
			Node next;
			
			Node(int val) {
				this.val = val;
			}
		}
	}
//	static class FirstUnique {
//
//		Queue<Integer> queue;
//		Map<Integer, Integer> map;
//
//		public FirstUnique(int[] nums) {
//			queue = new LinkedList<>();
//			map = new HashMap<>();
//			for (int num : nums) {
//				add(num);
//			}
//		}
//
//		public int showFirstUnique() {
//			while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
//				queue.poll();
//			}
//			return queue.isEmpty() ? -1 : queue.peek();
//		}
//
//		public void add(int value) {
//			map.put(value, map.getOrDefault(value, 0) + 1);
//			queue.offer(value);
//		}
//	}
}
