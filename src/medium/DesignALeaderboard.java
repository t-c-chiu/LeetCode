package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DesignALeaderboard {
	
	public static void main(String[] args) {
		Leaderboard leaderboard = new Leaderboard();
		leaderboard.addScore(1, 73);   // leaderboard = [[1,73]];
		leaderboard.addScore(2, 56);   // leaderboard = [[1,73],[2,56]];
		leaderboard.addScore(3, 39);   // leaderboard = [[1,73],[2,56],[3,39]];
		leaderboard.addScore(4, 51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
		leaderboard.addScore(5, 4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
		leaderboard.top(1);           // returns 73;
		leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
		leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
		leaderboard.addScore(2, 51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
		leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
	}
	
	static class Leaderboard {
		
		Map<Integer, Integer> playerToScore;
		TreeMap<Integer, Integer> scoreToCount;
		
		public Leaderboard() {
			playerToScore = new HashMap<>();
			scoreToCount = new TreeMap<>(Comparator.reverseOrder());
		}
		
		public void addScore(int playerId, int score) {
			if (playerToScore.containsKey(playerId)) {
				Integer oldScore = playerToScore.get(playerId);
				scoreToCount.put(oldScore, scoreToCount.get(oldScore) - 1);
				scoreToCount.remove(oldScore, 0);
			}
			score += playerToScore.getOrDefault(playerId, 0);
			playerToScore.put(playerId, score);
			scoreToCount.put(score, scoreToCount.getOrDefault(score, 0) + 1);
		}
		
		public int top(int K) {
			int res = 0;
			for (Integer score : scoreToCount.keySet()) {
				int min = Math.min(K, scoreToCount.get(score));
				res += score * min;
				K -= min;
				if (K == 0) {
					break;
				}
			}
			return res;
		}
		
		public void reset(int playerId) {
			Integer score = playerToScore.get(playerId);
			scoreToCount.put(score, scoreToCount.get(score) - 1);
			scoreToCount.remove(score, 0);
			playerToScore.remove(playerId);
		}
	}
	
}
