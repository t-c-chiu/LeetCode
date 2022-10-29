package hard;

public class IntegerToEnglishWords {
	
	public static void main(String[] args) {
		String res = numberToWords(123);
		System.out.println(res);
	}
	
	final static String[] LESS_THAN_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	final static String[] TENS = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	final static int BILLION = 1000000000;
	final static int MILLION = 1000000;
	final static int THOUSAND = 1000;
	final static int HUNDRED = 100;
	
	public static String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		return helper(num).trim();
	}
	
	private static String helper(int num) {
		if (num >= BILLION) {
			return helper(num / BILLION) + " Billion " + helper(num % BILLION);
		} else if (num >= MILLION) {
			return helper(num / MILLION) + " Million " + helper(num % MILLION);
		} else if (num >= THOUSAND) {
			return helper(num / THOUSAND) + " Thousand " + helper(num % THOUSAND);
		} else if (num >= HUNDRED) {
			return (helper(num / HUNDRED) + " Hundred " + helper(num % HUNDRED)).trim();
		} else if (num >= 20) {
			return (TENS[num / 10] + " " + helper(num % 10)).trim();
		} else {
			return LESS_THAN_20[num];
		}
	}
	
}
