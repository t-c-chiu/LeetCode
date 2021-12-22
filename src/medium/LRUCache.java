package medium;

import java.util.*;

public class LRUCache {
	
	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		lRUCache.get(1);    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		lRUCache.get(2);    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		lRUCache.get(1);    // return -1 (not found)
		lRUCache.get(3);    // return 3
		lRUCache.get(4);    // return 4
	}
	
	Map<Integer, Node> map;
	Node head;
	Node tail;
	int capacity;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>(capacity);
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node node = map.get(key);
		removeNode(node);
		addToTail(node);
		return node.val;
	}
	
	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.val = value;
			removeNode(node);
			addToTail(node);
		} else if (map.size() == capacity) {
			map.remove(head.next.key);
			removeNode(head.next);
			Node node = new Node(key, value);
			addToTail(node);
			map.put(key, node);
		} else {
			Node node = new Node(key, value);
			addToTail(node);
			map.put(key, node);
		}
	}
	
	private void addToTail(Node node) {
		Node prev = tail.prev;
		tail.prev = node;
		prev.next = node;
		node.prev = prev;
		node.next = tail;
	}
	
	
	private void removeNode(Node node) {
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;
	}
	
	class Node {
		int key;
		int val;
		Node prev;
		Node next;
		
		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
