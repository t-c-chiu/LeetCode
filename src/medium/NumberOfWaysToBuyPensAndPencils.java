package medium;

public class NumberOfWaysToBuyPensAndPencils {
	
	public static void main(String[] args) {
		long res = waysToBuyPensPencils(20, 10, 5);
		System.out.println(res);
	}
	
	public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
		long res = 0;
		int count = 0;
		while (total >= cost1 * count) {
			res += (total - cost1 * count) / cost2 + 1;
			count++;
		}
		return res;
	}
}
