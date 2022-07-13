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
	int capacity;
	Node head;
	Node tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node node = map.get(key);
		remove(node);
		addToHead(node);
		return node.val;
	}
	
	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	private void addToHead(Node node) {
		Node next = head.next;
		head.next = node;
		node.prev = head;
		node.next = next;
		next.prev = node;
	}
	
	public void put(int key, int value) {
		Node node;
		if (map.containsKey(key)) {
			node = map.get(key);
			node.val = value;
			remove(node);
		} else {
			node = new Node(key, value);
			map.put(key, node);
		}
		addToHead(node);
		if (map.size() > capacity) {
			map.remove(tail.prev.key);
			remove(tail.prev);
		}
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
