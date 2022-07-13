package easy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
	
	public static void main(String[] args) {
		List<String> res = subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
		System.out.println(res);
	}
	
	public static List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> map = new HashMap<>();
		for (String cpdomain : cpdomains) {
			String[] info = cpdomain.split(" ");
			String[] domains = info[1].split("\\.");
			int count = Integer.parseInt(info[0]);
			int n = domains.length;
			String cur = domains[n - 1];
			map.put(cur, map.getOrDefault(cur, 0) + count);
			for (int i = n - 2; i >= 0; i--) {
				cur = domains[i] + "." + cur;
				map.put(cur, map.getOrDefault(cur, 0) + count);
			}
		}
		
		List<String> res = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			res.add(entry.getValue() + " " + entry.getKey());
		}
		return res;
	}
}
