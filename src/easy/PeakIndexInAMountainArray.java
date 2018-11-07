package easy;

public class PeakIndexInAMountainArray {

	public static void main(String[] args) {
	}

	public int peakIndexInMountainArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			if (A[i + 1] < A[i])
				return i;
		}
		return -1;
	}
}
