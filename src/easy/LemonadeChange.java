package easy;

public class LemonadeChange {
	
	public static void main(String[] args) {
		LemonadeChange test = new LemonadeChange();
		System.out.println(test.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
		System.out.println(test.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
	}
	
	public boolean lemonadeChange(int[] bills) {
		int five = 0, ten = 0;
		for (int change : bills) {
			switch (change) {
				case 5:
					five++;
					break;
				case 10:
					five--;
					ten++;
					break;
				case 20:
					if (ten > 0) {
						ten--;
						five--;
					} else
						five -= 3;
			}
			if (five < 0)
				return false;
		}
		return true;
	}
}
