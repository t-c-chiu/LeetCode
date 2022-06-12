package easy;

public class DetectCapital {
	
	public static void main(String[] args) {
		boolean res = detectCapitalUse("FLaG");
		System.out.println(res);
	}
	
	public static boolean detectCapitalUse(String word) {
		int capitalCount = 0;
		for (int i = 0; i < word.length(); i++) {
			if (Character.isUpperCase(word.charAt(i))) {
				capitalCount++;
			}
		}
		return capitalCount == 0 || capitalCount == word.length() || (capitalCount == 1 && Character.isUpperCase(word.charAt(0)));
	}
}
