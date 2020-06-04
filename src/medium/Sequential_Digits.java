package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sequential_Digits {
	
	public static void main(String[] args) {
		Sequential_Digits test = new Sequential_Digits();
		List<Integer> res = test.sequentialDigits(1000, 13000);
		System.out.println(res);
	}
	
	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			sequentialDigits(res, 0, i, low, high);
		}
		res.sort(Comparator.naturalOrder());
		return res;
	}
	
	private void sequentialDigits(List<Integer> res, int temp, int i, int low, int high) {
		if (temp > high || i > 10) {
			return;
		} else if (temp >= low) {
			res.add(temp);
		}
		sequentialDigits(res, temp * 10 + i, i + 1, low, high);
	}
}
