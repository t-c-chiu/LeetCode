package easy;

public class BestPokerHand {
	
	public static void main(String[] args) {
	
	}
	
	public static String bestHand(int[] ranks, char[] suits) {
		int suit = 0, max = 0;
		int[] count = new int[14];
		for (int i = 0; i < ranks.length; i++) {
			if (suits[i] == suits[0]) {
				suit++;
			}
			count[ranks[i]]++;
			max = Math.max(max, count[ranks[i]]);
		}
		return suit == 5 ? "Flush" : max >= 3 ? "Three of a Kind" : max == 2 ? "Pair" : "High Card";
	}
	
}
