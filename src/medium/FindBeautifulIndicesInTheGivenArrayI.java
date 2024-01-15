package medium;

import java.util.ArrayList;
import java.util.List;

public class FindBeautifulIndicesInTheGivenArrayI {
	
	public static void main(String[] args) {
		List<Integer> res = beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15);
		System.out.println(res);
	}
	
	public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
		List<Integer> res = new ArrayList<>();
		List<Integer> aIndices = new ArrayList<>();
		List<Integer> bIndices = new ArrayList<>();
		int from = 0;
		while (s.indexOf(a, from) != -1) {
			int j = s.indexOf(a, from);
			aIndices.add(j);
			from = j + 1;
		}
		from = 0;
		while (s.indexOf(b, from) != -1) {
			int j = s.indexOf(b, from);
			bIndices.add(j);
			from = j + 1;
		}
		int i = 0, j = 0;
		while (i < aIndices.size() && j < bIndices.size()) {
			int aIndex = aIndices.get(i);
			int bIndex = bIndices.get(j);
			if (Math.abs(aIndex - bIndex) <= k) {
				res.add(aIndex);
				i++;
			} else if (aIndex < bIndex) {
				i++;
			} else {
				j++;
			}
		}
		return res;
	}
	
}
