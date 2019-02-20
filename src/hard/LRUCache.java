package hard;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}

	private Map<Integer, Node> map;
	private Node head;
	private Node tail;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>(capacity);
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node != null) {
			deleteNode(node);
			addToHead(node);
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node != null) {
			deleteNode(node);
			addToHead(node);
			map.get(key).value = value;
		} else {
			node = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
			}
			addToHead(node);
			map.put(key, node);
		}
	}

	private void addToHead(Node node) {
		Node next = head.next;
		next.pre = node;
		node.next = next;
		node.pre = head;
		head.next = node;
	}

	private void deleteNode(Node node) {
		Node pre = node.pre;
		node.next.pre = pre;
		pre.next = node.next;
	}

	private class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
