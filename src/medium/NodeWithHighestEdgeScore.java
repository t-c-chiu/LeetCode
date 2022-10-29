package medium;

public class NodeWithHighestEdgeScore {
	
	public static void main(String[] args) {
		int res = edgeScore(new int[]{1, 0, 0, 0, 0, 7, 7, 5});
		System.out.println(res);
	}
	
	public static int edgeScore(int[] edges) {
		int n = edges.length, res = 0, max = 0;
		int[] score = new int[n];
		for (int i = 0; i < n; i++) {
			int to = edges[i];
			score[to] += i;
			if (score[to] > max || score[to] == max && to < res) {
				max = score[to];
				res = to;
			}
		}
		return res;
	}
}
