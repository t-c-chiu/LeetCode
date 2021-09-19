package medium;

public class JumpGameIII {
	
	public static void main(String[] args) {
		boolean res = canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5);
		System.out.println(res);
	}
	
	public static boolean canReach(int[] arr, int start) {
		return start >= 0 && start < arr.length && arr[start] >= 0 && ((arr[start] = -arr[start]) == 0 || canReach(arr, start - arr[start]) || canReach(arr, start + arr[start]));
	}

//	public static boolean canReach(int[] arr, int start) {
//		int n = arr.length;
//		boolean[] visited = new boolean[n];
//		Queue<int[]> queue = new LinkedList<>();
//		queue.offer(new int[]{start, arr[start]});
//		while (!queue.isEmpty()) {
//			int[] cell = queue.poll();
//			int index = cell[0];
//			int jump = cell[1];
//			if (jump == 0) {
//				return true;
//			}
//			visited[index] = true;
//			int[] next = new int[]{index - jump, index + jump};
//			for (int i : next) {
//				if (i >= 0 && i < n && !visited[i]) {
//					queue.offer(new int[]{i, arr[i]});
//				}
//			}
//		}
//		return false;
//	}
}
