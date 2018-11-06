package easy;

public class SortArrayByParity {
	public static void main(String[] args) {
		for (int i : new SortArrayByParity().sortArrayByParity(new int[]{3, 1, 2, 4})) {
			System.out.println(i);
		}
	}
	
	public int[] sortArrayByParity(int[] A) {
		int[] result = new int[A.length];
		int evenIndex = 0;
		int oddIndex = result.length - 1;
		for (int i : A)
			result[i % 2 == 0 ? evenIndex++ : oddIndex--] = i;
		return result;
	}
}
