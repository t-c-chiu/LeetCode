package medium;

public class Count_Number_of_Teams {
	
	public static void main(String[] args) {
		Count_Number_of_Teams test = new Count_Number_of_Teams();
		int res = test.numTeams(new int[]{2, 5, 3, 4, 1});
		System.out.println(res);
	}
	
	public int numTeams(int[] rating) {
		int res = 0;
		
		for (int i = 1; i < rating.length - 1; i++) {
			int[] less = new int[2], greater = new int[2];
			for (int j = 0; j < rating.length; j++) {
				if (rating[i] > rating[j]) {
					less[i > j ? 0 : 1]++;
				}
				if (rating[i] < rating[j]) {
					greater[i > j ? 0 : 1]++;
				}
			}
			res += less[0] * greater[1] + less[1] * greater[0];
		}
		
		return res;
	}
}
