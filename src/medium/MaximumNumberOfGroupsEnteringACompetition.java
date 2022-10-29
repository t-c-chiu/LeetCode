package medium;

public class MaximumNumberOfGroupsEnteringACompetition {
	
	public static void main(String[] args) {
		int res = maximumGroups(new int[]{10, 6, 12, 7, 3, 5});
		System.out.println(res);
	}
	
	public static int maximumGroups(int[] grades) {
		int grouped = 0, nextGroup = 1;
		while (grouped + nextGroup <= grades.length) {
			grouped += nextGroup;
			nextGroup++;
		}
		return nextGroup - 1;
	}
}
