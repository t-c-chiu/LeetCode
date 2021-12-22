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
		buildGraph(graph, equations, values);
		
		double[] res = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			String q1 = query.get(0);
			String q2 = query.get(1);
			if (!graph.containsKey(q1) || !graph.containsKey(q2)) {
				res[i] = -1;
				continue;
			}
			if (q1.equals(q2)) {
				res[i] = 1;
				continue;
			}
			res[i] = dfs(graph, q1, q2, new HashSet<>());
		}
		return res;
	}
	
	private static void buildGraph(Map<String, Map<String, Double>> graph, List<List<String>> equations, double[] values) {
		for (int i = 0; i < equations.size(); i++) {
			List<String> equation = equations.get(i);
			String s1 = equation.get(0);
			String s2 = equation.get(1);
			graph.putIfAbsent(s1, new HashMap<>());
			graph.putIfAbsent(s2, new HashMap<>());
			graph.get(s1).put(s2, values[i]);
			graph.get(s2).put(s1, 1 / values[i]);
		}
	}
	
	private static double dfs(Map<String, Map<String, Double>> graph, String cur, String target, Set<String> seen) {
		if (seen.contains(cur)) {
			return -1;
		}
		seen.add(cur);
		if (graph.get(cur).containsKey(target)) {
			return graph.get(cur).get(target);
		}
		for (Map.Entry<String, Double> next : graph.get(cur).entrySet()) {
			double res = dfs(graph, next.getKey(), target, seen);
			if (res != -1) {
				return res * next.getValue();
			}
		}
		seen.remove(cur);
		return -1;
	}
}
