package easy;

public class CountOddNumbersInAnIntervalRange {
	
	public static void main(String[] args) {
		int res = countOdds(8, 10);
		System.out.println(res);
	}
	
	public static int countOdds(int low, int high) {
		return (high + 1) / 2 - low / 2;
	}
}
