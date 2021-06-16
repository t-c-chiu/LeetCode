package medium;

import java.util.*;

public class AccountsMerge {
	
	public static void main(String[] args) {
		List<List<String>> res = accountsMerge(Arrays.asList(
				Arrays.asList("David", "David0@m.co", "David1@m.co"),
				Arrays.asList("David", "David3@m.co", "David4@m.co"),
				Arrays.asList("David", "David4@m.co", "David5@m.co"),
				Arrays.asList("David", "David2@m.co", "David3@m.co"),
				Arrays.asList("David", "David1@m.co", "David2@m.co")
		));
		System.out.println(res);
	}
	
	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> emailToName = new HashMap<>();
		Map<String, Set<String>> graph = new HashMap<>();
		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				String email = account.get(i);
				emailToName.putIfAbsent(email, name);
				graph.putIfAbsent(email, new HashSet<>());
				Set<String> mappings = graph.get(email);
				for (int j = 1; j < account.size(); j++) {
					if (i == j) {
						continue;
					}
					mappings.add(account.get(j));
				}
			}
		}
		
		Set<String> visited = new HashSet<>();
		List<List<String>> res = new ArrayList<>();
		for (String email : graph.keySet()) {
			List<String> list = new ArrayList<>();
			if (!visited.contains(email)) {
				visited.add(email);
				dfs(graph, email, visited, list);
				list.sort(Comparator.naturalOrder());
				list.add(0, emailToName.get(email));
				res.add(list);
			}
		}
		return res;
	}
	
	private static void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
		list.add(email);
		Set<String> next = graph.get(email);
		for (String s : next) {
			if (!visited.contains(s)) {
				visited.add(s);
				dfs(graph, s, visited, list);
			}
		}
	}
}
