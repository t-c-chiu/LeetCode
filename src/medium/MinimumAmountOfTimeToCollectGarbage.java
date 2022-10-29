package medium;

public class MinimumAmountOfTimeToCollectGarbage {
	
	public static void main(String[] args) {
		int res = garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10});
		System.out.println(res);
	}
	
	public static int garbageCollection(String[] garbage, int[] travel) {
		int m = garbage.length, totalPaper = 0, totalGlass = 0, totalMetal = 0;
		int[] paperCount = new int[m], glassCount = new int[m], metalCount = new int[m];
		for (int i = 0; i < m; i++) {
			for (char c : garbage[i].toCharArray()) {
				if (c == 'P') {
					paperCount[i]++;
					totalPaper++;
				} else if (c == 'G') {
					glassCount[i]++;
					totalGlass++;
				} else {
					metalCount[i]++;
					totalMetal++;
				}
			}
		}
		return collect(travel, paperCount, totalPaper) + collect(travel, glassCount, totalGlass) + collect(travel, metalCount, totalMetal);
	}
	
	private static int collect(int[] travel, int[] count, int total) {
		int time = 0;
		for (int i = 0; i < count.length && total > 0; i++) {
			if (i > 0) {
				time += travel[i - 1];
			}
			time += count[i];
			total -= count[i];
		}
		return time;
	}
}
