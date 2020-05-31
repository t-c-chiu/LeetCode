package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
	
	public static void main(String[] args) {
		List<List<Integer>> res =
				new GroupThePeopleGivenTheGroupSizeTheyBelongTo().groupThePeople(new int[]{2, 1, 3, 3, 3, 2});
		System.out.println(res);
	}
	
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, List<Integer>> groupBySize = new HashMap<>();
		for (int i = 0; i < groupSizes.length; i++) {
			int size = groupSizes[i];
			List<Integer> group = groupBySize.computeIfAbsent(size, k -> new ArrayList<>());
			group.add(i);
			if (group.size() == size) {
				res.add(group);
				groupBySize.remove(size);
			}
		}
		return res;
	}
}
