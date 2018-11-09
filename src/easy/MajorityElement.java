package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElement {

	public static void main(String[] args) {
		int res = new MajorityElement().majorityElement(new int[]{2, 2, 2, 1, 1, 1, 2});
		System.out.println(res);
	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (!map.containsKey(i))
				map.put(i, 1);
			else
				map.put(i, map.get(i) + 1);
		}
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		for (Map.Entry<Integer, Integer> entry : set) {
			if (entry.getValue() > nums.length / 2)
				return entry.getKey();
		}
		return -1;
	}
}
