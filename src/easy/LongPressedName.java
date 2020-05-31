package easy;

public class LongPressedName {
	
	public static void main(String[] args) {
		LongPressedName test = new LongPressedName();
		System.out.println(test.isLongPressedName("alex", "aaleex"));
		System.out.println(test.isLongPressedName("saeed", "ssaaedd"));
		System.out.println(test.isLongPressedName("leelee", "lleeelee"));
		System.out.println(test.isLongPressedName("laiden", "laiden"));
	}
	
	public boolean isLongPressedName(String name, String typed) {
		int i = 0, j = 0;
		while (i < name.length()) {
			if (j == typed.length())
				return false;
			if (name.charAt(i) == typed.charAt(j))
				i++;
			j++;
		}
		return true;
	}
}
