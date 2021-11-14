package easy;

public class ArrangingCoins {
	
	public static void main(String[] args) {
		int res = arrangeCoins(5);
		System.out.println(res);
	}
	
	public static int arrangeCoins(int n) {
		int row = 1;
		while (n >= row) {
			n -= row;
			row++;
		}
		return row - 1;
	}
	
}
