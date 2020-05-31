package easy;

public class PartitionArrayIntoThreePartsWithEqualSum {
	
	public static void main(String[] args) {
		PartitionArrayIntoThreePartsWithEqualSum test = new PartitionArrayIntoThreePartsWithEqualSum();
		boolean ans = test.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1});
		System.out.println(ans);
		
		ans = test.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4});
		System.out.println(ans);
		
		ans = test.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1});
		System.out.println(ans);
	}
	
	public boolean canThreePartsEqualSum(int[] A) {
		int sum = 0;
		for (int i : A)
			sum += i;
		
		if (sum % 3 != 0)
			return false;
		
		return helper(A, sum / 3, 0);
	}
	
	private boolean helper(int[] A, int eachSum, int index) {
		if (index == A.length)
			return true;
		
		int sum = 0;
		for (int i = index; i < A.length; i++) {
			sum += A[i];
			if (sum == eachSum && helper(A, eachSum, i + 1))
				return true;
		}
		return false;
	}
}
