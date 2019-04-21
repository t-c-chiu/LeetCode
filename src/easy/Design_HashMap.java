package easy;

import java.util.Arrays;

public class Design_HashMap {
	class MyHashMap {
		int[] ints;
		
		/**
		 * Initialize your data structure here.
		 */
		public MyHashMap() {
			ints = new int[1000001];
			Arrays.fill(ints, -1);
		}
		
		/**
		 * value will always be non-negative.
		 */
		public void put(int key, int value) {
			ints[key] = value;
		}
		
		/**
		 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
		 */
		public int get(int key) {
			return ints[key];
		}
		
		/**
		 * Removes the mapping of the specified value key if this map contains a mapping for the key
		 */
		public void remove(int key) {
			ints[key] = -1;
		}
	}
}
