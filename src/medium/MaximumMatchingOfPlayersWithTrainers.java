package medium;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {
	
	public static void main(String[] args) {
		int res = matchPlayersAndTrainers(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8});
		System.out.println(res);
	}
	
	public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
		Arrays.sort(players);
		Arrays.sort(trainers);
		int i = 0, j = 0, res = 0;
		while (i < players.length && j < trainers.length) {
			if (players[i] <= trainers[j]) {
				res++;
				i++;
			}
			j++;
		}
		return res;
	}
}
