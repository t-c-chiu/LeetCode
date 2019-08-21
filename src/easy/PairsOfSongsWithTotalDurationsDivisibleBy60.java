package easy;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
	
	public static void main(String[] args) {
		PairsOfSongsWithTotalDurationsDivisibleBy60 test = new PairsOfSongsWithTotalDurationsDivisibleBy60();
		final int ans = test.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
		System.out.println(ans);
	}
	
	public int numPairsDivisibleBy60(int[] time) {
		int ans = 0;
		int[] arr = new int[60];
		for (int second : time) {
			ans += arr[(60 - second % 60) % 60];
			arr[second % 60] += 1;
		}
		return ans;
	}
}
