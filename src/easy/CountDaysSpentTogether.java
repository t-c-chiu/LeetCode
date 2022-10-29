package easy;

public class CountDaysSpentTogether {
	
	public static void main(String[] args) {
		int res = countDaysTogether("10-01", "10-31", "11-01", "12-31");
		System.out.println(res);
	}
	
	public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] preSumDays = new int[12];
		preSumDays[0] = days[0];
		for (int i = 1; i < 12; i++) {
			preSumDays[i] = preSumDays[i - 1] + days[i];
		}
		int arrive = Math.max(getDays(preSumDays, arriveAlice), getDays(preSumDays, arriveBob));
		int leave = Math.min(getDays(preSumDays, leaveAlice), getDays(preSumDays, leaveBob));
		return Math.max(0, leave - arrive + 1);
	}
	
	private static int getDays(int[] preSum, String date) {
		String[] split = date.split("-");
		int month = Integer.parseInt(split[0]);
		int day = Integer.parseInt(split[1]);
		return (month > 1 ? preSum[month - 2] : 0) + day;
	}
}
