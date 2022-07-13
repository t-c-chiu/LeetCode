package medium;

public class NumberOfLaserBeamsInABank {
	
	public static void main(String[] args) {
		int res = numberOfBeams(new String[]{
				"011001",
				"000000",
				"010100",
				"001000"});
		System.out.println(res);
	}
	
	public static int numberOfBeams(String[] bank) {
		int res = 0, prev = 0;
		for (String row : bank) {
			int count = 0;
			for (int i = 0; i < row.length(); i++) {
				if (row.charAt(i) == '1') {
					count++;
				}
			}
			if (count > 0) {
				res += prev * count;
				prev = count;
			}
		}
		return res;
	}
}
