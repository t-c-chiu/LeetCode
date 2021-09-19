package medium;

import java.util.*;

public class SmallestCommonRegion {
	
	public static void main(String[] args) {
		String res = findSmallestRegion(Arrays.asList(
				Arrays.asList("Earth", "North America", "South America"),
				Arrays.asList("North America", "United States", "Canada"),
				Arrays.asList("United States", "New York", "Boston"),
				Arrays.asList("Canada", "Ontario", "Quebec"),
				Arrays.asList("South America", "Brazil")
		), "Ontario", "United States");
		System.out.println(res);
	}
	
	public static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
		Map<String, String> map = new HashMap<>();
		for (List<String> region : regions) {
			for (int i = 1; i < region.size(); i++) {
				map.put(region.get(i), region.get(0));
			}
		}
		
		Set<String> find = new HashSet<>();
		while (region1 != null) {
			find.add(region1);
			region1 = map.get(region1);
		}
		while (region2 != null) {
			if (find.contains(region2)) {
				return region2;
			}
			region2 = map.get(region2);
		}
		return "";
	}
}
