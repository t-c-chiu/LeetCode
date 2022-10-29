package medium;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
	
	public static void main(String[] args) {
		List<String> res = mostVisitedPattern(
				new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"},
				new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
				new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"});
		System.out.println(res);
	}
	
	public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		int n = username.length;
		List<Info> infos = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			infos.add(new Info(username[i], timestamp[i], website[i]));
		}
		infos.sort(Comparator.comparingInt(info -> info.timestamp));
		Map<String, List<String>> userToWebsites = new HashMap<>();
		for (Info info : infos) {
			userToWebsites.putIfAbsent(info.name, new ArrayList<>());
			userToWebsites.get(info.name).add(info.website);
		}
		int max = 0;
		String res = "";
		Map<String, Integer> freq = new HashMap<>();
		for (List<String> websites : userToWebsites.values()) {
			int size = websites.size();
			if (size < 3) {
				continue;
			}
			Set<String> patterns = new HashSet<>();
			for (int i = 0; i < size; i++) {
				for (int j = i + 1; j < size; j++) {
					for (int k = j + 1; k < size; k++) {
						patterns.add(websites.get(i) + " " + websites.get(j) + " " + websites.get(k));
					}
				}
			}
			for (String pattern : patterns) {
				freq.put(pattern, freq.getOrDefault(pattern, 0) + 1);
				int count = freq.get(pattern);
				if (count > max || count == max && pattern.compareTo(res) < 0) {
					max = count;
					res = pattern;
				}
			}
		}
		return List.of(res.split(" "));
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
