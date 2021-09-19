package medium;

import java.util.*;

public class PathWithMaximumProbability {
	
	public static void main(String[] args) {
		double res = maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2);
		System.out.println(res);
	}
	
	public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		Map<Integer, List<double[]>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			graph.get(edge[0]).add(new double[]{edge[1], succProb[i]});
			graph.get(edge[1]).add(new double[]{edge[0], succProb[i]});
		}
		double[] prob = new double[n];
		PriorityQueue<Double[]> queue = new PriorityQueue<>((o1, o2) -> o2[1].compareTo(o1[1]));
		queue.offer(new Double[]{(double) start, 1d});
		while (!queue.isEmpty()) {
			Double[] cur = queue.poll();
			if (cur[0] == end) {
				return cur[1];
			}
			
			for (double[] next : graph.get(cur[0].intValue())) {
				int index = (int) next[0];
				double curProb = cur[1], nextProb = next[1];
				if (curProb * nextProb > prob[index]) {
					prob[index] = curProb * nextProb;
					queue.offer(new Double[]{(double) index, prob[index]});
				}
			}
		}
		return prob[end];
	}
}
