package easy;

public class TotalDistanceTraveled {
	
	public static void main(String[] args) {
		int res = distanceTraveled(1, 2);
		System.out.println(res);
	}
	
	public static int distanceTraveled(int mainTank, int additionalTank) {
		int res = 0;
		while (mainTank > 0) {
			int cost = Math.min(mainTank, 5);
			mainTank -= cost;
			res += cost;
			if (cost == 5 && additionalTank > 0) {
				mainTank++;
				additionalTank--;
			}
		}
		return res * 10;
	}
}
