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
		Map<Integer, Map<Integer, Integer>> tweet;
		int order = 0;
		
		public Twitter() {
			follow = new HashMap<>();
			tweet = new HashMap<>();
		}
		
		public void postTweet(int userId, int tweetId) {
			tweet.putIfAbsent(userId, new HashMap<>());
			tweet.get(userId).put(order++, tweetId);
		}
		
		public List<Integer> getNewsFeed(int userId) {
			PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getKey() - o1.getKey());
			Map<Integer, Integer> tweets = tweet.get(userId);
			if (tweets != null) {
				queue.addAll(tweets.entrySet());
			}
			Set<Integer> followees = follow.get(userId);
			if (followees != null) {
				for (Integer followeeId : followees) {
					Map<Integer, Integer> followeeTweets = tweet.get(followeeId);
					if (followeeTweets != null) {
						queue.addAll(followeeTweets.entrySet());
					}
				}
			}
			List<Integer> res = new ArrayList<>();
			int k = 10;
			while (!queue.isEmpty() && k > 0) {
				res.add(queue.poll().getValue());
				k--;
			}
			return res;
		}
		
		public void follow(int followerId, int followeeId) {
			follow.putIfAbsent(followerId, new HashSet<>());
			follow.get(followerId).add(followeeId);
		}
		
		public void unfollow(int followerId, int followeeId) {
			Set<Integer> followees = follow.get(followerId);
			if (followees != null) {
				followees.remove(followeeId);
			}
		}
	}
}
