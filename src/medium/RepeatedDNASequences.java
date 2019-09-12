package medium;

import java.util.*;

public class RepeatedDNASequences {
	
	public static void main(String[] args) {
		RepeatedDNASequences test = new RepeatedDNASequences();
		System.out.println(test.findRepeatedDnaSequences("AAAAAAAAAAA"));
	}
	
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> seen = new HashSet<>();
		Set<String> repeated = new HashSet<>();
		
		for (int i = 0; i + 9 < s.length(); i++) {
			String str = s.substring(i, i + 10);
			if (!seen.add(str))
				repeated.add(str);
		}
		
		return new ArrayList<>(repeated);
	}
}
