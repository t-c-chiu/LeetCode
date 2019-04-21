package easy;

public class Design_HashSet {
	class MyHashSet {
		boolean[] booleans;
		
		/**
		 * Initialize your data structure here.
		 */
		public MyHashSet() {
			booleans = new boolean[1000001];
		}
		
		public void add(int key) {
			booleans[key] = true;
		}
		
		public void remove(int key) {
			booleans[key] = false;
		}
		
		/**
		 * Returns true if this set contains the specified element
		 */
		public boolean contains(int key) {
			return booleans[key];
		}
	}
}
