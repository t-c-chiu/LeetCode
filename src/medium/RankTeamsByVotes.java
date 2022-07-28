package medium;

import java.util.*;

public class RankTeamsByVotes {
	
	public static void main(String[] args) {
		String res = rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"});
		System.out.println(res);
	}
	
	public static String rankTeams(String[] votes) {
		int n = votes[0].length();
		Map<Character, int[]> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (String vote : votes) {
				char team = vote.charAt(i);
				map.putIfAbsent(team, new int[n]);
				map.get(team)[i]++;
			}
		}
		List<Character> list = new ArrayList<>(map.keySet());
		list.sort((a, b) -> {
			int[] voteA = map.get(a);
			int[] voteB = map.get(b);
			for (int i = 0; i < n; i++) {
				if (voteA[i] != voteB[i]) {
					return voteB[i] - voteA[i];
				}
			}
			return a - b;
		});
		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			sb.append(c);
		}
		return sb.toString();
	}
}
