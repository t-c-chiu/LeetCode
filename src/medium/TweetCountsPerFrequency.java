package medium;

import java.util.*;

public class TweetCountsPerFrequency {
	
	public static void main(String[] args) {
		TweetCounts tweetCounts = new TweetCounts();
		tweetCounts.recordTweet("tweet3", 0);                              // New tweet "tweet3" at time 0
		tweetCounts.recordTweet("tweet3", 60);                             // New tweet "tweet3" at time 60
		tweetCounts.recordTweet("tweet3", 10);                             // New tweet "tweet3" at time 10
		tweetCounts.recordTweet("tweet3", 10);                             // New tweet "tweet3" at time 10
		List<Integer> res = tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59);// return [2]; chunk [0,59] had 2 tweets
		System.out.println(res);
		res = tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // return [2,1]; chunk [0,59] had 2 tweets, chunk [60,60] had 1 tweet
		System.out.println(res);
		tweetCounts.recordTweet("tweet3", 120);                            // New tweet "tweet3" at time 120
		res = tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // return [4]; chunk [0,210] had 4 tweets
		System.out.println(res);
	}
	
	static class TweetCounts {
		Map<String, TreeMap<Integer, Integer>> map;
		
		public TweetCounts() {
			map = new HashMap<>();
		}
		
		public void recordTweet(String tweetName, int time) {
			TreeMap<Integer, Integer> record = this.map.getOrDefault(tweetName, new TreeMap<>());
			record.put(time, record.getOrDefault(time, 0) + 1);
			map.putIfAbsent(tweetName, record);
		}
		
		public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
			int delta = getDelta(freq);
			List<Integer> res = new ArrayList<>();
			TreeMap<Integer, Integer> records = map.get(tweetName);
			for (int start = startTime; start <= endTime; start += delta) {
				int end = Math.min(start + delta, endTime + 1);
				int count = records.subMap(start, end).values().stream().mapToInt(Integer::valueOf).sum();
				res.add(count);
			}
			return res;
		}
		
		private int getDelta(String freq) {
			if (freq.equals("minute")) return 60;
			else if (freq.equals("hour")) return 3600;
			return 86400;
		}
	}
	
}
