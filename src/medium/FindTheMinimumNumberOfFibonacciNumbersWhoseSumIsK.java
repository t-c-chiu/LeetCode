package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
	
	public static void main(String[] args) {
		int res = findMinFibonacciNumbers(19);
		System.out.println(res);
	}
	
	public static int findMinFibonacciNumbers(int k) {
		if (k < 2) {
			return k;
		}
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0, j = 1; j <= k; ) {
			int temp = j;
			j += i;
			i = temp;
			set.add(j);
		}
		int res = 0;
		while (k > 0) {
			res++;
			k -= set.floor(k);
		}
		return res;
	}
}
