package easy;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
	
	public static void main(String[] args) {
		int res = numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
		System.out.println(res);
	}
	
	public static int numPairsDivisibleBy60(int[] time) {
		int res = 0;
		int[] count = new int[60];
		for (int i : time) {
			if (i % 60 == 0) {
				res += count[0];
				count[0]++;
			} else {
				res += count[60 - i % 60];
				count[i % 60]++;
			}
		}
		return res;
	}
}
