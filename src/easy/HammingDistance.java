package easy;

public class HammingDistance {
	public static void main(String[] args) {
		System.out.println(new HammingDistance().hammingDistance(1, 4));
	}
	
	public int hammingDistance(int x, int y) {
		int i = x ^ y;
		int count = 0;
		while (i > 0) {
			if (i % 2 == 1)
				count++;
			i >>= 1;
		}
		return count;
	}
}
