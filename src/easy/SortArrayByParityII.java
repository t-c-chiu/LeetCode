package easy;

public class SortArrayByParityII {

	public static void main(String[] args) {
	}

	public int[] sortArrayByParityII(int[] A) {
		int[] result = new int[A.length];
		int evenIndex = 0;
		int oddIndex = 1;
		for (int i : A) {
			if (i % 2 == 0) {
				result[evenIndex] = i;
				evenIndex += 2;
			} else {
				result[oddIndex] = i;
				oddIndex += 2;
			}
		}
		return result;
	}
}
