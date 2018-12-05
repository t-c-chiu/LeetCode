package medium;

public class CountingBits {
	public static void main(String[] args) {
		CountingBits countingBits = new CountingBits();
		for (int i : countingBits.countBits(2))
			System.out.println(i);
		System.out.println("-----");
		for (int i : countingBits.countBits(5)) {
			System.out.println(i);
		}
	}

	// 0 -> 0
	// 1 -> 1
	// 2 -> 10
	// 3 -> 11
	// 4 -> 100
	// 5 -> 101
	// 6 -> 110
	// 7 -> 111
	// 8 -> 1000
	// 1 bits的數量:
	// 奇數 = 偶數 + 1
	// 偶數 = 偶數 / 2
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0)
				result[i] = result[i / 2];
			else
				result[i] = result[i - 1] + 1;
		}
		return result;
	}
}
