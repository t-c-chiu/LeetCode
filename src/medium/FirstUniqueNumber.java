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
		
		Node head;
		Node tail;
		Map<Integer, Node> map;
		
		class Node {
			int value;
			Node prev;
			Node next;
			
			Node(int value) {
				this.value = value;
			}
		}
		
		public FirstUnique(int[] nums) {
			head = new Node(0);
			tail = new Node(0);
			head.next = tail;
			tail.prev = head;
			map = new HashMap<>();
			for (int num : nums) {
				add(num);
			}
		}
		
		public int showFirstUnique() {
			return head.next == tail ? -1 : head.next.value;
		}
		
		public void add(int value) {
			if (map.containsKey(value)) {
				remove(value);
			} else {
				addToEnd(value);
			}
		}
		
		private void addToEnd(int value) {
			Node node = new Node(value);
			map.put(value, node);
			node.prev = tail.prev;
			node.next = tail;
			tail.prev.next = node;
			tail.prev = node;
		}
		
		private void remove(int value) {
			Node node = map.get(value);
			if (node.prev == null || node.next == null) {
				return;
			}
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.prev = null;
			node.next = null;
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
