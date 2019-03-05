package easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
	public static void main(String[] args) {
		FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
		System.out.println(findCommonCharacters.commonChars(new String[]{"bella", "label", "roller"}));
		System.out.println(findCommonCharacters.commonChars(new String[]{"cool", "lock", "cook"}));
	}

	public List<String> commonChars(String[] A) {
		List<String> res = new ArrayList<>();
		outloop:
		for (Character c : A[0].toCharArray()) {
			for (int i = 1; i < A.length; i++) {
				if (A[i].indexOf(c) == -1)
					continue outloop;
				else
					A[i] = A[i].replaceFirst(c.toString(), "");
			}
			res.add(c.toString());
		}
		return res;
	}
}
