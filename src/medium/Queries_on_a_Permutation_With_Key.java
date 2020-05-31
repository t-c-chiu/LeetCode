package medium;

import java.util.Arrays;
import java.util.LinkedList;

public class Queries_on_a_Permutation_With_Key {
	
	public static void main(String[] args) {
		Queries_on_a_Permutation_With_Key test = new Queries_on_a_Permutation_With_Key();
		int[] res = test.processQueries(new int[]{3, 1, 2, 1}, 5);
		Arrays.stream(res).forEach(System.out::print);
	}
	
	public int[] processQueries(int[] queries, int m) {
		int[] res = new int[queries.length];
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= m; i++) {
			list.add(i);
		}
		
		for (int i = 0; i < queries.length; i++) {
			int target = queries[i];
			int index = list.indexOf(target);
			list.addFirst(list.remove(index));
			res[i] = index;
		}
		
		return res;
	}
}
