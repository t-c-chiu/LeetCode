package easy;

import java.util.ArrayList;
import java.util.List;

public class RansomNote {
	public static void main(String[] args) {
		System.out.println(new RansomNote().canConstruct("aa", "aba"));
	}
	
	public boolean canConstruct(String ransomNote, String magazine) {
		int length = 0;
		List<Character> list = new ArrayList<>();
		for (Character character : magazine.toCharArray())
			list.add(character);
		
		for (Character character : ransomNote.toCharArray()) {
			if (list.remove(character)) {
				length++;
			} else
				return false;
		}
		return length == ransomNote.length();
	}
}
