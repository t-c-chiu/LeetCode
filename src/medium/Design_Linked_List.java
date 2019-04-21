package medium;

public class Design_Linked_List {
	
	public static void main(String[] args) {
		MyLinkedList list = new Design_Linked_List().new MyLinkedList();
		list.addAtTail(3);
		list.printHead();
		list.addAtHead(1);
		list.printHead();
		list.addAtIndex(0, 0);
		list.addAtIndex(2, 2);
		list.addAtIndex(4, 4);
		list.addAtIndex(99, 99);
		list.printHead();
		list.deleteAtIndex(0);
		list.printHead();
		list.deleteAtIndex(2);
		list.printHead();
		list.deleteAtIndex(3);
		list.printHead();
	}
	
	class MyLinkedList {
		private Node head;
		
		/**
		 * Initialize your data structure here.
		 */
		public MyLinkedList() {
		}
		
		/**
		 * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
		 */
		public int get(int index) {
			if (index < 0)
				return -1;
			
			Node tmp = head;
			while (tmp != null) {
				if (index-- == 0)
					return tmp.val;
				tmp = tmp.next;
			}
			return -1;
		}
		
		/**
		 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
		 */
		public void addAtHead(int val) {
			Node tmp = head;
			head = new Node(val);
			head.next = tmp;
		}
		
		/**
		 * Append a node of value val to the last element of the linked list.
		 */
		public void addAtTail(int val) {
			if (head == null) {
				addAtHead(val);
				return;
			}
			Node tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;
			tmp.next = new Node(val);
		}
		
		/**
		 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
		 */
		public void addAtIndex(int index, int val) {
			if (index <= 0) {
				addAtHead(val);
				return;
			}
			Node tmp = head;
			while (tmp != null) {
				if (--index == 0) {
					Node next = tmp.next;
					tmp.next = new Node(val);
					if (next != null)
						tmp.next.next = next;
					return;
				}
				tmp = tmp.next;
			}
		}
		
		/**
		 * Delete the index-th node in the linked list, if the index is valid.
		 */
		public void deleteAtIndex(int index) {
			if (index == 0) {
				head = head.next;
				return;
			}
			
			Node tmp = head;
			while (tmp != null && tmp.next != null) {
				if (--index == 0) {
					tmp.next = tmp.next.next;
					return;
				}
				tmp = tmp.next;
			}
		}
		
		public void printHead() {
			System.out.println(head);
		}
		
		private class Node {
			public int val;
			public Node next;
			
			public Node(int x) {
				val = x;
			}
			
			@Override
			public String toString() {
				return "ListNode{" +
						"val=" + val +
						", next=" + next +
						'}';
			}
		}
	}
}
