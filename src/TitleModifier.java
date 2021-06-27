public class TitleModifier {
	
	public static void main(String[] args) {
		String str = "";
		char[] chars = str.toCharArray();
		for (int i = 1; i < chars.length; i++) {
			if (chars[i - 1] == ' ') {
				chars[i] = Character.toUpperCase(chars[i]);
			}
		}
		str = String.valueOf(chars).replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(str);
	}
	
}
