package medium;

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
	
	public static void main(String[] args) {
		int res = numSteps("1101");
		System.out.println(res);
	}
	
	public static int numSteps(String s) {
		int res = 0, carry = 0;
		for (int i = s.length() - 1; i >= 1; i--) {
			if (s.charAt(i) - '0' + carry == 1) {
				carry = 1;
				res += 2;
			} else {
				res++;
			}
		}
		return res + carry;
	}
}
