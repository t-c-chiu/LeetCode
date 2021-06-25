package medium;

import java.util.*;

public class AllPathsFromSourceLeadToDestination {
	
	public static void main(String[] args) {
		boolean res = leadsToDestination(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}, 0, 3);
		System.out.println(res);
	}
	
	public static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		buildGraph(edges, graph);
		Set<Integer> visited = new HashSet<>();
		visited.add(source);
		return dfs(source, destination, graph, visited);
	}
	
	private static boolean dfs(int source, int destination, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
		List<Integer> list = graph.get(source);
		if (list == null) {
			return source == destination;
		}
		
		for (Integer next : list) {
			if (visited.contains(next)) {
				return false;
			}
			visited.add(next);
			if (!dfs(next, destination, graph, visited)) {
				return false;
			}
			visited.remove(next);
		}
		return true;
	}
	
	private static void buildGraph(int[][] edges, Map<Integer, List<Integer>> graph) {
		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(edge[1]);
		}
	}
}
