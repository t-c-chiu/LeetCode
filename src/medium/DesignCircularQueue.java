package medium;

public class DesignCircularQueue {
	
	public static void main(String[] args) {
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		myCircularQueue.enQueue(1); // return True
		myCircularQueue.enQueue(2); // return True
		myCircularQueue.enQueue(3); // return True
		myCircularQueue.enQueue(4); // return False
		System.out.println(myCircularQueue.Rear());     // return 3
		myCircularQueue.isFull();   // return True
		myCircularQueue.deQueue();  // return True
		myCircularQueue.enQueue(4); // return True
		System.out.println(myCircularQueue.Rear());     // return 4
	}
	
	static class MyCircularQueue {
		
		int k, count, first, last = -1;
		int[] queue;
		
		public MyCircularQueue(int k) {
			this.k = k;
			queue = new int[k];
		}
		
		public boolean enQueue(int value) {
			if (isFull()) {
				return false;
			}
			last = (last + 1) % k;
			queue[last] = value;
			count++;
			return true;
		}
		
		public boolean deQueue() {
			if (isEmpty()) {
				return false;
			}
			first = (first + 1) % k;
			count--;
			return true;
		}
		
		public int Front() {
			if (isEmpty()) {
				return -1;
			}
			return queue[first];
		}
		
		public int Rear() {
			if (isEmpty()) {
				return -1;
			}
			return queue[last];
		}
		
		public boolean isEmpty() {
			return count == 0;
		}
		
		public boolean isFull() {
			return count == k;
		}
	}
}
