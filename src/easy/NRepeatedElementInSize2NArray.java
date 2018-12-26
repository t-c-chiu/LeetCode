package easy;

public class NRepeatedElementInSize2NArray {
	public static void main(String[] args) {
		NRepeatedElementInSize2NArray nRepeatedElementInSize2NArray = new NRepeatedElementInSize2NArray();
		System.out.println(nRepeatedElementInSize2NArray.repeatedNTimes(new int[]{1, 2, 3, 3}));
		System.out.println(nRepeatedElementInSize2NArray.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
		System.out.println(nRepeatedElementInSize2NArray.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
	}

	//	Input: [1,2,3,3]
	//	Output: 3
	public int repeatedNTimes(int[] A) {
		int n = A.length / 2;
		int[] array = new int[10000];
		for (int i : A) {
			if (++array[i] == n)
				return i;
		}
		return -1;
	}
}

