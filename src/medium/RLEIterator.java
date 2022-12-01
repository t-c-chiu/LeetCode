package medium;

public class RLEIterator {
	
	public static void main(String[] args) {
		RLEIterator rLEIterator = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5}); // This maps to the sequence [8,8,8,5,5].
		System.out.println(rLEIterator.next(2)); // exhausts 2 terms of the sequence, returning 8. The remaining sequence is now [8, 5, 5].
		System.out.println(rLEIterator.next(1)); // exhausts 1 term of the sequence, returning 8. The remaining sequence is now [5, 5].
		System.out.println(rLEIterator.next(1)); // exhausts 1 term of the sequence, returning 5. The remaining sequence is now [5].
		System.out.println(rLEIterator.next(2)); // exhausts 2 terms, returning -1. This is because the first term exhausted was 5, but the second term did not exist.Since the last term exhausted does not exist, we return -1.
	}
	
	int[] encoding;
	int index;
	
	public RLEIterator(int[] encoding) {
		this.encoding = encoding;
		index = 0;
	}
	
	public int next(int n) {
		while (index < encoding.length && n > encoding[index]) {
			n -= encoding[index];
			encoding[index] = 0;
			index += 2;
		}
		if (index >= encoding.length) {
			return -1;
		}
		encoding[index] -= n;
		return encoding[index + 1];
	}
}
