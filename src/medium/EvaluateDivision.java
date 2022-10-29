package medium;

import java.util.*;

public class EvaluateDivision {
	
	public static void main(String[] args) {
		double[] res = calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")),
				new double[]{2.0, 3.0},
				Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")));
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> graph = new HashMap<>();
		int n = equations.size();
		for (int i = 0; i < n; i++) {
			List<String> equation = equations.get(i);
			String x = equation.get(0);
			String y = equation.get(1);
			graph.putIfAbsent(x, new HashMap<>());
			graph.get(x).put(y, values[i]);
			graph.putIfAbsent(y, new HashMap<>());
			graph.get(y).put(x, 1 / values[i]);
		}
		int m = queries.size();
		double[] res = new double[m];
		for (int i = 0; i < m; i++) {
			List<String> query = queries.get(i);
			String x = query.get(0);
			String y = query.get(1);
			if (!graph.containsKey(x) || !graph.containsKey(y)) {
				res[i] = -1;
				continue;
			}
			Set<String> seen = new HashSet<>();
			seen.add(x);
			res[i] = dfs(graph, x, y, seen, 1);
		}
		return res;
	}
	
	private static double dfs(Map<String, Map<String, Double>> graph, String from, String target, Set<String> seen, double product) {
		if (from.equals(target)) {
			return product;
		}
		Map<String, Double> next = graph.get(from);
		for (String n : next.keySet()) {
			if (seen.contains(n)) {
				continue;
			}
			seen.add(n);
			double temp = dfs(graph, n, target, seen, product * next.get(n));
			if (temp != -1) {
				return temp;
			}
			seen.remove(n);
		}
		return -1;
	}
}
