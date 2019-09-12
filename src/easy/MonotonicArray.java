package easy;

public class MonotonicArray {
	
	public static void main(String[] args) {
		MonotonicArray test = new MonotonicArray();
		
		boolean ans = test.isMonotonic(new int[]{1, 2, 2, 3});
		System.out.println(ans);
		
		ans = test.isMonotonic(new int[]{6, 5, 4, 4});
		System.out.println(ans);
		
		ans = test.isMonotonic(new int[]{1, 3, 2});
		System.out.println(ans);
	}
	
	public boolean isMonotonic(int[] A) {
		boolean increase = false;
		boolean decrease = false;
		
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1])
				increase = true;
			if (A[i] < A[i - 1])
				decrease = true;
		}
		
		return !(increase && decrease);
	}
}
