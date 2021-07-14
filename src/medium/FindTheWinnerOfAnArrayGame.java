package medium;

public class FindTheWinnerOfAnArrayGame {
	
	public static void main(String[] args) {
		int res = getWinner(new int[]{1, 25, 35, 42, 68, 70}, 1);
		System.out.println(res);
	}
	
	public static int getWinner(int[] arr, int k) {
		int winner = arr[0];
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > winner) {
				winner = arr[i];
				count = 1;
			} else {
				count++;
			}
			if (count == k) {
				return winner;
			}
		}
		return winner;
	}
}
