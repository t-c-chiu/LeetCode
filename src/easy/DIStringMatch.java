package easy;

import java.util.LinkedList;
import java.util.List;

public class DIStringMatch {
	public static void main(String[] args) {
		for (int i : new DIStringMatch().diStringMatch0("IDDID"))
			System.out.println(i);
	}

	//	Input:"IDID" 0 - 01 - 021 - 0213 - 02143
	//	Input:"III" 0 - 01 - 012 - 0123
	//	Input:"DDD" 0 - 10 - 210 - 3210
	//	Input:"DIDI" 0 - 10 - 102 - 1032 - 10324
	//	Input:"IIDDD" 0 - 01 - 012 - 0132 - 01432 - 015432
	//	Input:"IDDID" 0 - 01 - 021 - 0321 - 03214 - 032154
	public int[] diStringMatch(String S) {
		List<Integer> list = new LinkedList<>();
		list.add(0);
		int lastNumIndex = 0;
		char[] chars = S.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			int num = i + 1;
			if (c == 'I') {
				list.add(num);
			} else {
				list.add(lastNumIndex, num);
			}
			lastNumIndex = list.indexOf(num);
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

	public int[] diStringMatch0(String S) {
		int[] result = new int[S.length() + 1];
		int min = 0;
		int max = S.length();
		char[] chars = S.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if ('I' == chars[i])
				result[i] = min++;
			else
				result[i] = max--;
		}
		result[result.length - 1] = max;
		return result;
	}
}
