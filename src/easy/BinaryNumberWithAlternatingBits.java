package easy;

public class BinaryNumberWithAlternatingBits {
	
	public static void main(String[] args) {
		BinaryNumberWithAlternatingBits binaryNumberWithAlternatingBits = new BinaryNumberWithAlternatingBits();
		System.out.println(binaryNumberWithAlternatingBits.hasAlternatingBits(5));
		System.out.println(binaryNumberWithAlternatingBits.hasAlternatingBits(8));
		System.out.println(binaryNumberWithAlternatingBits.hasAlternatingBits(10));
	}
	
	// 2 - 10
	// 3 - 11
	// 4 - 100
	// 5 - 101
	// 6 - 110
	// 7 - 111
	// 8 - 1000
	// 9 - 1001
	// 10 - 1010
	public boolean hasAlternatingBits(int n) {
		boolean nextNumShouldBeOdd = n % 2 == 0;
		while (n > 0) {
			n >>= 1;
			boolean isEven = n % 2 == 0;
			if (nextNumShouldBeOdd == isEven)
				return false;
			nextNumShouldBeOdd = !nextNumShouldBeOdd;
		}
		return true;
	}
}
