package medium;

import java.util.ArrayList;
import java.util.List;

public class MaximumSplitOfPositiveEvenIntegers {
	
	public static void main(String[] args) {
		List<Long> res = maximumEvenSplit(12);
		System.out.println(res);
	}
	
	public static List<Long> maximumEvenSplit(long finalSum) {
		if (finalSum % 2 == 1) {
			return new ArrayList<>();
		}
		List<Long> res = new ArrayList<>();
		for (long i = 2; finalSum >= i; i += 2) {
			if (finalSum - i > i) {
				res.add(i);
				finalSum -= i;
			} else {
				res.add(finalSum);
				break;
			}
		}
		return res;
	}
}
