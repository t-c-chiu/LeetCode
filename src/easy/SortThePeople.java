package easy;

import java.util.TreeMap;

public class SortThePeople {
	
	public static void main(String[] args) {
		sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170});
	}
	
	public static String[] sortPeople(String[] names, int[] heights) {
		int n = names.length;
		String[] res = new String[n];
		TreeMap<Integer, String> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			map.put(heights[i], names[i]);
		}
		int i = 0;
		while (!map.isEmpty()) {
			res[i++] = map.pollLastEntry().getValue();
		}
		return res;
	}
}
