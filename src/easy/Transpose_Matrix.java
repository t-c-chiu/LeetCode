package easy;

public class Transpose_Matrix {
	
	public static void main(String[] args) {
	
	}
	
	//Input: [[1,2,3],[4,5,6]]
	//Output: [[1,4],[2,5],[3,6]]
	public int[][] transpose(int[][] A) {
		if (A.length == 0)
			return null;
		int[][] res = new int[A[0].length][A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				res[j][i] = A[i][j];
			}
		}
		return res;
	}
}
