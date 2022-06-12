package medium;

import java.util.*;

public class KillProcess {
	
	public static void main(String[] args) {
		List<Integer> res = killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5);
		System.out.println(res);
	}
	
	public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		Map<Integer, List<Integer>> graph = buildGraph(pid, ppid);
		List<Integer> res = new ArrayList<>();
		kill(graph, res, kill);
		return res;
	}
	
	private static Map<Integer, List<Integer>> buildGraph(List<Integer> pid, List<Integer> ppid) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < pid.size(); i++) {
			Integer parentId = ppid.get(i);
			graph.putIfAbsent(parentId, new LinkedList<>());
			graph.get(parentId).add(pid.get(i));
		}
		return graph;
	}
	
	private static void kill(Map<Integer, List<Integer>> graph, List<Integer> res, int kill) {
		res.add(kill);
		if (graph.containsKey(kill)) {
			for (Integer child : graph.get(kill)) {
				kill(graph, res, child);
			}
		}
	}
}
