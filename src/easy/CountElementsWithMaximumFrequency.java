package easy;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
	
	public static void main(String[] args) {
		int res = maxFrequencyElements(new int[]{1, 1, 2, 2, 3});
		System.out.println(res);
	}
	
	public static int maxFrequencyElements(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}
		int count = 0, max = 0;
		for (Integer num : freq.keySet()) {
			Integer f = freq.get(num);
			if (f == max) {
				count++;
			} else if (f > max) {
				max = f;
				count = 1;
			}
		}
		return count * max;
	}
}
