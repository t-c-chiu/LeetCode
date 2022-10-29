package medium;

public class DesignHitCounter {
	
	public static void main(String[] args) {
		HitCounter hitCounter = new HitCounter();
		hitCounter.hit(1);       // hit at timestamp 1.
		hitCounter.hit(2);       // hit at timestamp 2.
		hitCounter.hit(3);       // hit at timestamp 3.
		int res = hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
		System.out.println(res);
		hitCounter.hit(300);     // hit at timestamp 300.
		res = hitCounter.getHits(300); // get hits at timestamp 300, return 4.
		System.out.println(res);
		res = hitCounter.getHits(301); // get hits at timestamp 301, return 3.
		System.out.println(res);
	}
	
	static class HitCounter {
		
		int[] timestamps;
		int[] hits;
		
		public HitCounter() {
			timestamps = new int[300];
			hits = new int[300];
		}
		
		public void hit(int timestamp) {
			int temp = timestamp % 300;
			if (timestamps[temp] == timestamp) {
				hits[temp]++;
			} else {
				timestamps[temp] = timestamp;
				hits[temp] = 1;
			}
		}
		
		public int getHits(int timestamp) {
			int count = 0;
			for (int i = 0; i < 300; i++) {
				if (timestamp - timestamps[i] < 300) {
					count += hits[i];
				}
			}
			return count;
		}
	}
	
}
