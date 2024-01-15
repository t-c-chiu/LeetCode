package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankTeamsByVotes {
	
	public static void main(String[] args) {
		String res = rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"});
		System.out.println(res);
	}
	
	public static String rankTeams(String[] votes) {
		Map<Character, int[]> map = new HashMap<>();
		int n = votes[0].length();
		for (int i = 0; i < n; i++) {
			for (String vote : votes) {
				char c = vote.charAt(i);
				map.putIfAbsent(c, new int[n]);
				map.get(c)[i]++;
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
		StringBuilder builder = new StringBuilder();
		for (Character c : list) {
			builder.append(c);
		}
		return builder.toString();
	}
	
}
