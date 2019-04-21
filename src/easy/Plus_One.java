package easy;

public class Plus_One {
	public static void main(String[] args) {
		Plus_One test = new Plus_One();
		for (int i : test.plusOne(new int[]{1, 2, 3, 4})) {
			System.out.print(i);
		}
		System.out.println();
		for (int i : test.plusOne(new int[]{9, 9, 9, 9})) {
			System.out.print(i);
		}
		System.out.println();
		for (int i : test.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})) {
			System.out.print(i);
		}
	}
	
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}
}
