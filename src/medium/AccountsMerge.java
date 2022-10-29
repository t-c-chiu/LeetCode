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
		Map<String, Set<String>> graph = new HashMap<>();
		Map<String, String> emailToName = new HashMap<>();
		Set<String> seen = new HashSet<>();
		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				String cur = account.get(i);
				emailToName.put(cur, name);
				graph.putIfAbsent(cur, new HashSet<>());
				if (i > 1) {
					String prev = account.get(i - 1);
					graph.get(prev).add(cur);
					graph.get(cur).add(prev);
				}
			}
		}
		List<List<String>> res = new ArrayList<>();
		for (String email : emailToName.keySet()) {
			if (seen.contains(email)) {
				continue;
			}
			List<String> list = new ArrayList<>();
			dfs(list, graph, email, seen);
			list.sort(Comparator.naturalOrder());
			list.add(0, emailToName.get(email));
			res.add(list);
		}
		return res;
	}
	
	private static void dfs(List<String> list, Map<String, Set<String>> graph, String email, Set<String> seen) {
		list.add(email);
		seen.add(email);
		for (String next : graph.get(email)) {
			if (seen.contains(next)) {
				continue;
			}
			dfs(list, graph, next, seen);
		}
	}

//	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
//		List<List<String>> res = new ArrayList<>();
//		Map<String, String> emailToParent = new HashMap<>();
//		Map<String, List<String>> g = new HashMap<>();
//		Set<String> seen = new HashSet<>();
//		for (List<String> account : accounts) {
//			for (int i = 1; i < account.size(); i++) {
//				String email = account.get(i);
//				emailToParent.put(email, account.get(0));
//				if (i > 1) {
//					String firstEmail = account.get(1);
//					g.putIfAbsent(firstEmail, new ArrayList<>());
//					g.putIfAbsent(email, new ArrayList<>());
//					g.get(firstEmail).add(email);
//					g.get(email).add(firstEmail);
//				}
//			}
//		}
//		for (List<String> account : accounts) {
//			String firstEmail = account.get(1);
//			if (!seen.contains(firstEmail)) {
//				List<String> temp = new ArrayList<>();
//				seen.add(firstEmail);
//				dfs(temp, firstEmail, g, seen);
//				temp.sort(Comparator.naturalOrder());
//				temp.add(0, emailToParent.get(firstEmail));
//				res.add(temp);
//			}
//		}
//		return res;
//	}
//
//	private static void dfs(List<String> temp, String email, Map<String, List<String>> g, Set<String> seen) {
//		temp.add(email);
//		if (!g.containsKey(email)) {
//			return;
//		}
//		for (String next : g.get(email)) {
//			if (!seen.contains(next)) {
//				seen.add(next);
//				dfs(temp, next, g, seen);
//			}
//		}
//	}
}
