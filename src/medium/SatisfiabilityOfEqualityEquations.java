package medium;

public class SatisfiabilityOfEqualityEquations {
	
	public static void main(String[] args) {
		boolean res = equationsPossible(new String[]{"f==a", "a==b", "f!=e", "a==c", "b==e", "c==f"});
		System.out.println(res);
	}
	
	public static boolean equationsPossible(String[] equations) {
		int[] parent = new int[26];
		for (int i = 0; i < 26; i++) {
			parent[i] = i;
		}
		for (String equation : equations) {
			if (equation.charAt(1) == '=') {
				parent[find(parent, equation.charAt(0) - 'a')] = find(parent, equation.charAt(3) - 'a');
			}
		}
		for (String equation : equations) {
			if (equation.charAt(1) == '!' && find(parent, equation.charAt(0) - 'a') == find(parent, equation.charAt(3) - 'a')) {
				return false;
			}
		}
		return true;
	}
	
	private static int find(int[] parent, int i) {
		if (parent[i] != i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}
	
}
