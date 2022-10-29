package easy;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
	
	public static void main(String[] args) {
		boolean res = isStrobogrammatic("619");
		System.out.println(res);
	}
	
	public static boolean isStrobogrammatic(String num) {
		int left = 0, right = num.length() - 1;
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		while (left <= right) {
			char lc = num.charAt(left);
			char rc = num.charAt(right);
			if (!map.containsKey(lc) || !map.containsKey(rc) || map.get(lc) != rc) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
