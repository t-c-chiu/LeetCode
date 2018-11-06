package easy;

public class ToLowerCase {
	public static void main(String[] args) {
		ToLowerCase toLowerCase = new ToLowerCase();
		System.out.println(toLowerCase.toLowerCase("HELLO"));
		System.out.println(toLowerCase.toLowerCase("hello"));
	}
	
	public String toLowerCase(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (c >= 65 && c <= 90)
				c += 32;
			stringBuilder.append(c);
		}
		
		return stringBuilder.toString();
	}
}
