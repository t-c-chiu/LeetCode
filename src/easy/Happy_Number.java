package easy;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {
	
	public static void main(String[] args) {
		Happy_Number test = new Happy_Number();
		System.out.println(test.isHappy(2));
	}
	
	public boolean isHappy(int n) {
		Set<Integer> loop = new HashSet<>();
		while (loop.add(n)) {
			if (n == 1)
				return true;
			int nextNum = 0;
			while (n > 0) {
				nextNum += Math.pow(n % 10, 2);
				n /= 10;
			}
			n = nextNum;
		}
		return false;
	}
}
