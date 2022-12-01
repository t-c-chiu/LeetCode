package hard;

public class Candy {
	
	public static void main(String[] args) {
		int res = candy(new int[]{1, 2, 2});
		System.out.println(res);
	}
	
	public static int candy(int[] ratings) {
		int n = ratings.length;
		int[] count = new int[n];
		count[0] = 1;
		for (int i = 1; i < n; i++) {
			count[i] = ratings[i] > ratings[i - 1] ? count[i - 1] + 1 : 1;
		}
		int res = count[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			count[i] = ratings[i] > ratings[i + 1] ? Math.max(count[i], count[i + 1] + 1) : count[i];
			res += count[i];
		}
		return res;
	}
}
