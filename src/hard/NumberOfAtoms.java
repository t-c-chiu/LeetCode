package hard;

import java.util.*;

public class NumberOfAtoms {
	
	public static void main(String[] args) {
		String res = countOfAtoms("K4(ON(SO3)2)2");
		System.out.println(res);
	}
	
	public static String countOfAtoms(String formula) {
		Stack<Map<String, Integer>> stack = new Stack<>();
		Map<String, Integer> map = new HashMap<>();
		int i = 0, n = formula.length();
		while (i < n) {
			char c = formula.charAt(i);
			if (Character.isUpperCase(c)) {
				StringBuilder name = new StringBuilder("" + formula.charAt(i++));
				while (i < n && Character.isLowerCase(formula.charAt(i))) {
					name.append(formula.charAt(i));
					i++;
				}
				int num = 1;
				if (i < n && Character.isDigit(formula.charAt(i))) {
					num = 0;
					while (i < n && Character.isDigit(formula.charAt(i))) {
						num = num * 10 + formula.charAt(i) - '0';
						i++;
					}
				}
				String s = name.toString();
				map.put(s, map.getOrDefault(s, 0) + num);
			} else if (c == '(') {
				stack.push(map);
				map = new HashMap<>();
				i++;
			} else if (c == ')') {
				int count = 1;
				if (i + 1 < n && Character.isDigit(formula.charAt(i + 1))) {
					i++;
					count = 0;
					while (i < n && Character.isDigit(formula.charAt(i))) {
						count = count * 10 + formula.charAt(i) - '0';
						i++;
					}
				} else {
					i++;
				}
				if (count > 1) {
					for (String s : map.keySet()) {
						map.put(s, map.get(s) * count);
					}
				}
				Map<String, Integer> preMap = stack.pop();
				for (String s : preMap.keySet()) {
					map.put(s, map.getOrDefault(s, 0) + preMap.get(s));
				}
			}
		}
		StringBuilder res = new StringBuilder();
		TreeMap<String, Integer> treeMap = new TreeMap<>(map);
		for (String s : treeMap.keySet()) {
			res.append(s);
			if (treeMap.get(s) > 1) {
				res.append(treeMap.get(s));
			}
		}
		return res.toString();
	}
}
