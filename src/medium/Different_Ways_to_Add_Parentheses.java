package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Different_Ways_to_Add_Parentheses {
	
	public static void main(String[] args) {
		Different_Ways_to_Add_Parentheses test = new Different_Ways_to_Add_Parentheses();
		List<Integer> res = test.diffWaysToCompute("2*3-4*5");
		System.out.println(res);
	}
	
	private Map<String, List<Integer>> cache = new HashMap<>();
	
	public List<Integer> diffWaysToCompute(String input) {
		if (cache.containsKey(input)) {
			return cache.get(input);
		}
		
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for (Integer j : left) {
					for (Integer k : right) {
						switch (c) {
							case '+':
								res.add(j + k);
								break;
							case '-':
								res.add(j - k);
								break;
							case '*':
								res.add(j * k);
						}
					}
				}
			}
		}
		if (res.isEmpty()) {
			res.add(Integer.parseInt(input));
		}
		cache.put(input, res);
		return res;
	}
}
