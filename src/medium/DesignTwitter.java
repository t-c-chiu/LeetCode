package medium;

import java.util.*;

public class DesignTwitter {
	
	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
		List<Integer> res = twitter.getNewsFeed(1);// User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
		System.out.println(res);
		twitter.follow(1, 2);    // User 1 follows user 2.
		twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
		res = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		System.out.println(res);
		twitter.unfollow(1, 2);  // User 1 unfollows user 2.
		res = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
		System.out.println(res);
	}
	
	static class Twitter {
		
		Map<Integer, Set<Integer>> follow;
		Map<Integer, Set<int[]>> tweets;
		int timestamp;
		
		public Twitter() {
			follow = new HashMap<>();
			tweets = new HashMap<>();
		}
		
		public void postTweet(int userId, int tweetId) {
			follow.putIfAbsent(userId, new HashSet<>());
			follow.get(userId).add(userId);
			tweets.putIfAbsent(userId, new HashSet<>());
			tweets.get(userId).add(new int[]{tweetId, timestamp++});
		}
		
		public List<Integer> getNewsFeed(int userId) {
			if (!follow.containsKey(userId)) {
				return new ArrayList<>();
			}
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o[1]));
			for (Integer followee : follow.get(userId)) {
				if (tweets.containsKey(followee)) {
					pq.addAll(tweets.get(followee));
				}
			}
			List<Integer> res = new ArrayList<>();
			while (!pq.isEmpty() && res.size() < 10) {
				res.add(pq.poll()[0]);
			}
			return res;
		}
		
		public void follow(int followerId, int followeeId) {
			follow.putIfAbsent(followerId, new HashSet<>());
			follow.get(followerId).add(followeeId);
		}
		
		public void unfollow(int followerId, int followeeId) {
			if (follow.containsKey(followerId)) {
				follow.get(followerId).remove(followeeId);
			}
		}
	}
}
