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
		List<List<String>> res = new ArrayList<>();
		Map<String, String> emailToParent = new HashMap<>();
		Map<String, List<String>> g = new HashMap<>();
		Set<String> seen = new HashSet<>();
		for (List<String> account : accounts) {
			for (int i = 1; i < account.size(); i++) {
				String email = account.get(i);
				emailToParent.put(email, account.get(0));
				if (i > 1) {
					String firstEmail = account.get(1);
					g.putIfAbsent(firstEmail, new ArrayList<>());
					g.putIfAbsent(email, new ArrayList<>());
					g.get(firstEmail).add(email);
					g.get(email).add(firstEmail);
				}
			}
		}
		for (List<String> account : accounts) {
			String firstEmail = account.get(1);
			if (!seen.contains(firstEmail)) {
				List<String> temp = new ArrayList<>();
				seen.add(firstEmail);
				dfs(temp, firstEmail, g, seen);
				temp.sort(Comparator.naturalOrder());
				temp.add(0, emailToParent.get(firstEmail));
				res.add(temp);
			}
		}
		return res;
	}
	
	private static void dfs(List<String> temp, String email, Map<String, List<String>> g, Set<String> seen) {
		temp.add(email);
		if (!g.containsKey(email)) {
			return;
		}
		for (String next : g.get(email)) {
			if (!seen.contains(next)) {
				seen.add(next);
				dfs(temp, next, g, seen);
			}
		}
	}
}
