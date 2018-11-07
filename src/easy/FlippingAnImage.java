package easy;

public class FlippingAnImage {
	public static void main(String[] args) {
		int[][] res = new FlippingAnImage().flipAndInvertImage(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 1, 0}, {0, 0, 1, 1}});
		for (int[] i : res) {
			for (int j : i) {
				System.out.println(j);
			}
		}
	}

	public int[][] flipAndInvertImage(int[][] A) {
		int length = A.length;
		int[][] result = new int[length][];
		for (int i = 0; i < length; i++) {
			int[] innerA = A[i];
			int innerLength = innerA.length;
			int[] innerResult = new int[innerLength];
			for (int j = 0; j < innerLength; j++) {
				innerResult[j] = innerA[innerLength - j - 1] ^ 1;
			}
			result[i] = innerResult;
		}
		return result;
	}
}
