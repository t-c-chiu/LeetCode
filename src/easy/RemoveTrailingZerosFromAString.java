package easy;

public class RemoveTrailingZerosFromAString {
	
	public static void main(String[] args){
		String s = removeTrailingZeros("51230100");
		System.out.println(s);
	}
	
	public static String removeTrailingZeros(String num) {
		int i = num.length() - 1;
		while (i >= 0 && num.charAt(i) == '0') {
			i--;
		}
		return num.substring(0, i + 1);
	}
}
