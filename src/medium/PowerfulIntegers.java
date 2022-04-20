package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
	
	public static void main(String[] args) {
		List<Integer> res = powerfulIntegers(2, 3, 10);
		System.out.println(res);
	}
	
	public static List<Integer> powerfulIntegers(int x, int y, int bound) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i < bound; i *= x) {
			for (int j = 1; i + j <= bound; j *= y) {
				set.add(i + j);
				if (y == 1) {
					break;
				}
			}
			if (x == 1) {
				break;
			}
		}
		return set.stream().toList();
	}
}
