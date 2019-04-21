package medium;

public class Kth_Smallest_Element_in_a_Sorted_Matrix {
	public static void main(String[] args) {
		Kth_Smallest_Element_in_a_Sorted_Matrix test = new Kth_Smallest_Element_in_a_Sorted_Matrix();
		int res = test.kthSmallest(new int[][]{
				{1, 5, 9},
				{10, 11, 13},
				{12, 13, 15}
		}, 8);
		System.out.println(res);
	}
	
	// 先取left跟right 然後搜尋mid 判斷這整個matrix裡面比mid小的值有幾個
	// 如果比mid小的值的個數比K還少 表示目標數字在mid的右邊 把left設定成mid+1繼續搜尋 反之亦然
	// 最後left=right left就是第K個小的數字
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length, left = matrix[0][0], right = matrix[n - 1][n - 1], mid;
		while (left < right) {
			mid = left + (right - left) / 2;
			int count = 0, j = n - 1;
			for (int i = 0; i < n && j >= 0; i++) {
				while (j >= 0 && matrix[i][j] > mid)
					j--;
				count += j + 1;
			}
			if (count < k)
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
}
