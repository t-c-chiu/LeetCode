package medium;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyzeUserWebsiteVisitPattern {
	
	public static void main(String[] args) {
		List<String> res = mostVisitedPattern(
				new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"},
				new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
				new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"});
		System.out.println(res);
	}
	
	public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		List<Info> infos = new ArrayList<>();
		for (int i = 0; i < username.length; i++) {
			infos.add(new Info(username[i], timestamp[i], website[i]));
		}
		
		Map<String, List<String>> map = new HashMap<>();
		infos.sort(Comparator.comparingInt(info -> info.timestamp));
		for (Info info : infos) {
			map.putIfAbsent(info.name, new ArrayList<>());
			map.get(info.name).add(info.website);
		}
		
		Map<String, Integer> freq = new HashMap<>();
		int max = 0;
		String maxPattern = "";
		for (List<String> list : map.values()) {
			int n = list.size();
			if (n < 3) {
				continue;
			}
			Set<String> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					for (int k = j + 1; k < n; k++) {
						set.add(list.get(i) + " " + list.get(j) + " " + list.get(k));
					}
				}
			}
			
			for (String s : set) {
				int i = freq.getOrDefault(s, 0) + 1;
				if (i > max || i == max && s.compareTo(maxPattern) < 0) {
					max = i;
					maxPattern = s;
				}
				freq.put(s, i);
			}
		}
		
		return Arrays.stream(maxPattern.split(" ")).collect(Collectors.toList());
	}
	
	static class Info {
		String name;
		int timestamp;
		String website;
		
		public Info(String name, int timestamp, String website) {
			this.name = name;
			this.timestamp = timestamp;
			this.website = website;
		}
	}
}
