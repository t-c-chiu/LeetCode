package medium;

public class XOR_Queries_of_a_Subarray {
	
	public static void main(String[] args) {
		XOR_Queries_of_a_Subarray test = new XOR_Queries_of_a_Subarray();
		int[] res = test.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
		for (int i : res) {
			System.out.println(i);
		}
	}
	
	public int[] xorQueries(int[] arr, int[][] queries) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] ^ arr[i];
		}
		
		int[] res = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			res[i] = arr[query[1]];
			if (query[0] > 0) {
				res[i] ^= arr[query[0] - 1];
			}
		}
		return res;
	}
}
