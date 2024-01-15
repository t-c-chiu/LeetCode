package medium;

import java.util.*;

public class PathWithMaximumProbability {
	
	public static void main(String[] args) {
		double res = maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2);
		System.out.println(res);
	}
	
	public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		Map<Integer, List<double[]>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int u = edge[0], v = edge[1];
			map.get(u).add(new double[]{v, succProb[i]});
			map.get(v).add(new double[]{u, succProb[i]});
		}
		double[] probs = new double[n];
		PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> -o[1]));
		pq.offer(new double[]{start, 1d});
		while (!pq.isEmpty()) {
			double[] poll = pq.poll();
			int index = (int) poll[0];
			double prob = poll[1];
			if (index == end) {
				return prob;
			}
			for (double[] next : map.get(index)) {
				int nextIndex = (int) next[0];
				if (prob * next[1] > probs[nextIndex]) {
					probs[nextIndex] = prob * next[1];
					pq.offer(new double[]{nextIndex, probs[nextIndex]});
				}
			}
		}
		return 0;
	}
}
