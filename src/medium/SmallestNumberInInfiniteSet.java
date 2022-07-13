package medium;

public class SmallestNumberInInfiniteSet {
	
	public static void main(String[] args) {
		SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
		smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
		smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
		smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
		smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
		smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
		smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
		// is the smallest number, and remove it from the set.
		smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
		smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
	}
	
	static class SmallestInfiniteSet {
		
		boolean[] removed;
		int smallest;
		
		public SmallestInfiniteSet() {
			removed = new boolean[1001];
			smallest = 1001;
		}
		
		public int popSmallest() {
			for (int i = 1; i <= 1000; i++) {
				if (!removed[i]) {
					removed[i] = true;
					return i;
				}
			}
			return smallest++;
		}
		
		public void addBack(int num) {
			removed[num] = false;
		}
	}
}
