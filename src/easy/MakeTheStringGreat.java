package easy;

public class MakeTheStringGreat {
	
	public static void main(String[] args) {
		String res = makeGood("leEeetcode");
		System.out.println(res);
	}
	
	public static String makeGood(String s) {
		StringBuilder builder = new StringBuilder(s);
		int i = 1;
		while (i < builder.length()) {
			char c1 = builder.charAt(i - 1);
			char c2 = builder.charAt(i);
			if (Character.toUpperCase(c1) == Character.toUpperCase(c2)
					&& (Character.isUpperCase(c1) && Character.isLowerCase(c2)
					|| Character.isLowerCase(c1) && Character.isUpperCase(c2))) {
				builder.delete(i - 1, i + 1);
				i = Math.max(i - 1, 1);
			} else {
				i++;
			}
		}
		return builder.toString();
	}
}
