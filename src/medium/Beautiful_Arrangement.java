package medium;

public class Beautiful_Arrangement {
	
	public static void main(String[] args) {
		Beautiful_Arrangement test = new Beautiful_Arrangement();
		test.countArrangement(3);
	}
	
	private int count;
	
	public int countArrangement(int N) {
		countArrangement(N, N, new boolean[N + 1]);
		return count;
	}
	
	private void countArrangement(int N, int k, boolean[] visited) {
		if (k == 0) {
			count++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && (k % i == 0 || i % k == 0)) {
				visited[i] = true;
				countArrangement(N, k - 1, visited);
				visited[i] = false;
			}
		}
	}
}
