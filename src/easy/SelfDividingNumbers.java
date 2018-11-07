package easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

	public static void main(String[] args) {
		SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
		System.out.println(selfDividingNumbers.selfDividingNumbers(1, 22));
		System.out.println(selfDividingNumbers.selfDividingNumbers(66, 99));
	}

	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (verify(i))
				result.add(i);
		}
		return result;
	}

	private boolean verify(int i) {
		int temp = i;
		while (temp > 0) {
			int digit = temp % 10;
			if (digit == 0 || i % digit != 0)
				return false;
			temp /= 10;
		}
		return true;
	}
}
