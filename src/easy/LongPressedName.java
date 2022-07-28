package easy;

public class LongPressedName {
	
	public static void main(String[] args) {
		System.out.println(isLongPressedName("alex", "aaleex"));
		System.out.println(isLongPressedName("saeed", "ssaaedd"));
		System.out.println(isLongPressedName("leelee", "lleeelee"));
		System.out.println(isLongPressedName("laiden", "laiden"));
	}
	
	public static boolean isLongPressedName(String name, String typed) {
		int i = 0;
		for (int j = 0; j < typed.length(); j++) {
			if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
				i++;
			} else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
				return false;
			}
		}
		return i == name.length();
	}
}
