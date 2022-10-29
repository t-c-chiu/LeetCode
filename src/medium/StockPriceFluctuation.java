package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPriceFluctuation {
	
	public static void main(String[] args) {
		StockPrice stockPrice = new StockPrice();
		stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
		stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
		System.out.println(stockPrice.current());     // return 5, the latest timestamp is 2 with the price being 5.
		System.out.println(stockPrice.maximum());     // return 10, the maximum price is 10 at timestamp 1.
		stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
		// Timestamps are [1,2] with corresponding prices [3,5].
		System.out.println(stockPrice.maximum());     // return 5, the maximum price is 5 after the correction.
		stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
		System.out.println(stockPrice.minimum());     // return 2, the minimum price is 2 at timestamp 4.
	}
	
	static class StockPrice {
		
		Map<Integer, Integer> timestampToPrice;
		TreeMap<Integer, Integer> priceCount;
		int latest;
		
		public StockPrice() {
			timestampToPrice = new HashMap<>();
			priceCount = new TreeMap<>();
		}
		
		public void update(int timestamp, int price) {
			latest = Math.max(latest, timestamp);
			if (timestampToPrice.containsKey(timestamp)) {
				int oldPrice = timestampToPrice.get(timestamp);
				priceCount.put(oldPrice, priceCount.get(oldPrice) - 1);
				priceCount.remove(oldPrice, 0);
			}
			timestampToPrice.put(timestamp, price);
			priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
		}
		
		public int current() {
			return timestampToPrice.get(latest);
		}
		
		public int maximum() {
			return priceCount.lastKey();
		}
		
		public int minimum() {
			return priceCount.firstKey();
		}
	}
}
