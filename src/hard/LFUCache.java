package hard;

import java.util.*;

public class LFUCache {
	
	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(0);
		lfu.put(0, 0);
		lfu.get(0);
	}
	
	private int counter = 0;
	private int capacity;
	private Map<Integer, Integer> valMap = new HashMap<>();
	private Map<Integer, Integer> freqMap = new HashMap<>();
	private Map<Integer, Integer> recentMap = new HashMap<>();
	private TreeMap<Integer, Set<Integer>> numsByFreq = new TreeMap<>();
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		if (!valMap.containsKey(key)) {
			return -1;
		}
		updateFreqAndRecent(key);
		return valMap.get(key);
	}
	
	public void put(int key, int value) {
		if (capacity <= 0) {
			return;
		}
		
		if (valMap.containsKey(key) || valMap.size() < capacity) {
			valMap.put(key, value);
			updateFreqAndRecent(key);
		} else {
			Set<Integer> nums = numsByFreq.firstEntry().getValue();
			int lowestCount = Integer.MAX_VALUE;
			int keyToRemove = -1;
			for (Integer num : nums) {
				Integer counter = recentMap.get(num);
				if (counter < lowestCount) {
					lowestCount = counter;
					keyToRemove = num;
				}
			}
			nums.remove(keyToRemove);
			if (nums.isEmpty()) {
				numsByFreq.pollFirstEntry();
			}
			remove(keyToRemove);
			put(key, value);
		}
	}
	
	private void updateFreqAndRecent(int key) {
		Integer prevFreq = freqMap.get(key);
		if (prevFreq != null) {
			Set<Integer> set = numsByFreq.get(prevFreq);
			set.remove(key);
			if (set.isEmpty()) {
				numsByFreq.remove(prevFreq);
			}
		}
		int newFreq = prevFreq == null ? 1 : prevFreq + 1;
		Set<Integer> set = numsByFreq.getOrDefault(newFreq, new HashSet<>());
		set.add(key);
		numsByFreq.put(newFreq, set);
		freqMap.put(key, newFreq);
		recentMap.put(key, counter++);
	}
	
	private void remove(int key) {
		valMap.remove(key);
		freqMap.remove(key);
		recentMap.remove(key);
	}
}
