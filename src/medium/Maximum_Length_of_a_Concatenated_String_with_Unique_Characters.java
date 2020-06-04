package medium;

import java.util.Arrays;
import java.util.List;

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {
	
	public static void main(String[] args) {
		Maximum_Length_of_a_Concatenated_String_with_Unique_Characters test = new Maximum_Length_of_a_Concatenated_String_with_Unique_Characters();
		int res = test.maxLength(Arrays.asList("un", "iq", "ue"));
		System.out.println(res);
	}
	
	int max;
	
	public int maxLength(List<String> arr) {
		maxLength(arr, "", 0);
		return max;
	}
	
	private void maxLength(List<String> arr, String str, int start) {
		if (isUnique(str)) {
			max = Math.max(max, str.length());
		} else {
			return;
		}
		
		for (int i = start; i < arr.size(); i++) {
			maxLength(arr, str + arr.get(i), i + 1);
		}
	}
	
	public boolean isUnique(String str) {
		boolean[] used = new boolean[26];
		for (char c : str.toCharArray()) {
			int index = c - 'a';
			if (used[index]) {
				return false;
			}
			used[index] = true;
		}
		return true;
	}
}
