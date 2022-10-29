package medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1));    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2));    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1));    // return -1 (not found)
		System.out.println(lRUCache.get(3));    // return 3
		System.out.println(lRUCache.get(4));    // return 4
	}
	
	int capacity;
	Map<Integer, Node> map;
	Node head;
	Node tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
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
	
	private void removeNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	private void addToTail(Node node) {
		node.prev = tail.prev;
		node.next = tail;
		tail.prev.next = node;
		tail.prev = node;
	}
	
	public void put(int key, int value) {
		Node node;
		if (!map.containsKey(key)) {
			node = new Node(key, value);
			map.put(key, node);
		} else {
			node = map.get(key);
			node.val = value;
			removeNode(node);
		}
		addToTail(node);
		if (map.size() > capacity) {
			Node toRemove = head.next;
			map.remove(toRemove.key);
			removeNode(toRemove);
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
