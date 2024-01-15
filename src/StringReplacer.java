public class StringReplacer {
	
	public static void main(String[] args) {
		String s = replace("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]",
				new char[]{'"', '[', ']' },
				new char[]{'\'', '{', '}' });
		System.out.println(s);
	}
	
	public static String replace(String s, char[] oldChar, char[] newChar) {
		for (int i = 0; i < oldChar.length; i++) {
			s = s.replace(oldChar[i], newChar[i]);
		}
		return s;
	}
}
