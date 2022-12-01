package easy;

public class StudentAttendanceRecordI {
	
	public static void main(String[] args) {
		boolean res = checkRecord("PPALLP");
		System.out.println(res);
	}
	
	public static boolean checkRecord(String s) {
		int consecutiveL = 0, absentCount = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'A' && ++absentCount == 2 || c == 'L' && ++consecutiveL == 3) {
				return false;
			}
			if (c != 'L') {
				consecutiveL = 0;
			}
		}
		return true;
	}
}
