package medium;

import java.util.*;

public class Sort_Integers_by_The_Power_Value {
	
	public static void main(String[] args) {
		Sort_Integers_by_The_Power_Value test = new Sort_Integers_by_The_Power_Value();
		int res = test.getKth(12, 15, 2);
		System.out.println(res);
	}
	
	public int getKth(int lo, int hi, int k) {
		// we can reuse the number in
		Map<Integer, Integer> cache = new HashMap<>();
		List<int[]> list = new ArrayList<>();
		for (int i = lo; i <= hi; i++) {
			int j = i;
			int step = 0;
			while (j != 1) {
				if (cache.containsKey(j)) {
					step += cache.get(j);
					break;
				}
				if (j % 2 == 0) {
					j /= 2;
				} else {
					j = j * 3 + 1;
				}
				step++;
			}
			cache.put(i, step);
			list.add(new int[]{i, step});
		}
		// int[0] = number, int[1] = step
		list.sort(((o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]));
		return list.get(k - 1)[0];
	}
}