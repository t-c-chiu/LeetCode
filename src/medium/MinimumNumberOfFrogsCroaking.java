package medium;

public class MinimumNumberOfFrogsCroaking {
	
	public static void main(String[] args) {
		int res = minNumberOfFrogs("crocakcroraoakk");
		System.out.println(res);
	}
	
	public static int minNumberOfFrogs(String croakOfFrogs) {
		int[] count = new int[5];
		int maxFrogs = 0, frogs = 0;
		for (int i = 0; i < croakOfFrogs.length(); i++) {
			int index = "croak".indexOf(croakOfFrogs.charAt(i));
			count[index]++;
			if (index == 0) {
				frogs++;
				maxFrogs = Math.max(maxFrogs, frogs);
			} else if (--count[index - 1] < 0) {
				return -1;
			} else if (index == 4) {
				frogs--;
			}
		}
		return frogs == 0 ? maxFrogs : -1;
	}
}
