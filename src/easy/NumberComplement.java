package easy;

public class NumberComplement {
	public static void main(String[] args) {
		NumberComplement numberComplement = new NumberComplement();
		System.out.println(numberComplement.findComplement(5));
		System.out.println(numberComplement.findComplement(1));
	}

	// 5 -> 101 -> 010 -> 2
	// 1 -> 1 -> 0 -> 0
	public int findComplement(int num) {
		int allOneBit = 1;
		int temp = num;
		while (temp > 1) {
			temp >>= 1;
			allOneBit = (allOneBit << 1) + 1;
		}
		return num ^ allOneBit;
	}
}
