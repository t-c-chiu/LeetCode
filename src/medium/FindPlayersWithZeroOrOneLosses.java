package medium;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
	
	public static void main(String[] args) {
		List<List<Integer>> res = findWinners(new int[][]{
				{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}}
		);
		System.out.println(res);
	}
	
	public static List<List<Integer>> findWinners(int[][] matches) {
		Set<Integer> players = new HashSet<>();
		Set<Integer> loseOne = new HashSet<>();
		Set<Integer> loseMore = new HashSet<>();
		for (int[] match : matches) {
			int winner = match[0], loser = match[1];
			players.add(winner);
			players.add(loser);
			if (loseOne.contains(loser)) {
				loseOne.remove(loser);
				loseMore.add(loser);
			} else if (!loseMore.contains(loser)) {
				loseOne.add(loser);
			}
		}
		players.removeAll(loseOne);
		players.removeAll(loseMore);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> winner = new ArrayList<>(players);
		winner.sort(Comparator.naturalOrder());
		res.add(winner);
		List<Integer> losers = new ArrayList<>(loseOne);
		losers.sort(Comparator.naturalOrder());
		res.add(losers);
		return res;
	}
	
}
