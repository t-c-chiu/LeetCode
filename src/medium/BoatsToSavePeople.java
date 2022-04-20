package medium;

import java.util.Arrays;

public class BoatsToSavePeople {
	
	public static void main(String[] args) {
		int res = numRescueBoats(new int[]{3, 5, 3, 4}, 5);
		System.out.println(res);
	}
	
	public static int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int res = 0, l = 0, r = people.length - 1;
		while (l <= r) {
			if (people[l] + people[r] <= limit) {
				l++;
			}
			r--;
			res++;
		}
		return res;
	}
}
