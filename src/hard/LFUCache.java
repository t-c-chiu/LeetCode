package hard;

import java.util.*;

public class LFUCache {
	
	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(0);
		lfu.put(0, 0);
		lfu.get(0);
	}
	
	int capacity;
	int minFreq;
	Map<Integer, Integer> map;
	Map<Integer, Integer> freqMap;
	Map<Integer, LinkedHashSet<Integer>> freqToKeys;
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		freqMap = new HashMap<>();
		freqToKeys = new HashMap<>();
		freqToKeys.put(1, new LinkedHashSet<>());
	}
	
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Integer oldFreq = freqMap.get(key);
		LinkedHashSet<Integer> set = freqToKeys.get(oldFreq);
		set.remove(key);
		if (set.isEmpty() && minFreq == oldFreq) {
			minFreq++;
		}
		int newFreq = oldFreq + 1;
		freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
		freqToKeys.get(newFreq).add(key);
		freqMap.put(key, newFreq);
		return map.get(key);
	}
	
	public void put(int key, int value) {
		if (capacity == 0) {
			return;
		}
		if (map.containsKey(key)) {
			map.put(key, value);
			get(key);
			return;
		}
		if (map.size() == capacity) {
			LinkedHashSet<Integer> set = freqToKeys.get(minFreq);
			Integer keyToRemove = set.iterator().next();
			map.remove(keyToRemove);
			freqMap.remove(keyToRemove);
			set.remove(keyToRemove);
		}
		minFreq = 1;
		map.put(key, value);
		freqMap.put(key, 1);
		freqToKeys.get(1).add(key);
	}
}
