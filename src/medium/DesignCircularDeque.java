package medium;

public class DesignCircularDeque {
	
	public static void main(String[] args) {
		MyCircularDeque myCircularDeque = new MyCircularDeque(3);
		myCircularDeque.insertLast(1);  // return True
		myCircularDeque.insertLast(2);  // return True
		myCircularDeque.insertFront(3); // return True
		myCircularDeque.insertFront(4); // return False, the queue is full.
		myCircularDeque.getRear();      // return 2
		myCircularDeque.isFull();       // return True
		myCircularDeque.deleteLast();   // return True
		myCircularDeque.insertFront(4); // return True
		myCircularDeque.getFront();     // return 4
	}
	
	static class MyCircularDeque {
		
		Node head;
		Node tail;
		int max;
		int size;
		
		public MyCircularDeque(int k) {
			max = k;
		}
		
		public boolean insertFront(int value) {
			if (isFull()) {
				return false;
			}
			
			Node node = new Node(value);
			if (isEmpty()) {
				head = tail = node;
			} else {
				node.next = head;
				head.prev = node;
				head = node;
			}
			size++;
			return true;
		}
		
		public boolean insertLast(int value) {
			if (isFull()) {
				return false;
			}
			
			Node node = new Node(value);
			if (isEmpty()) {
				head = tail = node;
			} else {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
			size++;
			return true;
		}
		
		public boolean deleteFront() {
			if (isEmpty()) {
				return false;
			}
			head = head.next;
			size--;
			return true;
		}
		
		public boolean deleteLast() {
			if (isEmpty()) {
				return false;
			}
			tail = tail.prev;
			size--;
			return true;
		}
		
		public int getFront() {
			return isEmpty() ? -1 : head.val;
		}
		
		public int getRear() {
			return isEmpty() ? -1 : tail.val;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public boolean isFull() {
			return size == max;
		}
		
		private class Node {
			Node prev;
			Node next;
			int val;
			
			Node(int val) {
				this.val = val;
			}
		}
	}
}
