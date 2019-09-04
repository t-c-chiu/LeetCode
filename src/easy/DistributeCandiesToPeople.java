package easy;

import java.util.Arrays;

public class DistributeCandiesToPeople {
	
	public static void main(String[] args) {
		DistributeCandiesToPeople test = new DistributeCandiesToPeople();
		int[] ans = test.distributeCandies(7, 4);
		Arrays.stream(ans).forEach(System.out::print);
		System.out.println();
		
		ans = test.distributeCandies(10, 3);
		Arrays.stream(ans).forEach(System.out::print);
	}
	
	public int[] distributeCandies(int candies, int num_people) {
		int[] ans = new int[num_people];
		int give = 0;
		while (candies > 0) {
			ans[give % num_people] += Math.min(candies, ++give);
			candies -= give;
		}
		return ans;
	}
}
