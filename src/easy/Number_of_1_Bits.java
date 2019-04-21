package easy;

public class Number_of_1_Bits {
	public static void main(String[] args) {
		Number_of_1_Bits test = new Number_of_1_Bits();
		System.out.println(test.hammingWeight(1));
		System.out.println(test.hammingWeight(2));
		System.out.println(test.hammingWeight(3));
		System.out.println(test.hammingWeight(4));
		System.out.println(test.hammingWeight(5));
		System.out.println(test.hammingWeight(-3));
	}
	
	// 1 - 01 - 1
	// 2 - 10 - 1
	// 3 - 11 - 2
	// 4 - 100 - 1
	// 5 - 101 - 2
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			count += (n & 1);
			n >>>= 1;
		}
		return count;
	}
}
