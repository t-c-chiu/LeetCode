package easy;

public class FindWinnerOnATicTacToeGame {
	
	public static void main(String[] args) {
		String res = tictactoe(new int[][]{{2, 0}, {1, 0}, {1, 1}, {0, 2}});
		System.out.println(res);
	}
	
	public static String tictactoe(int[][] moves) {
		int n = moves.length;
		int[] row = new int[3], col = new int[3], diagonal = new int[2];
		for (int i = 0; i < n; i++) {
			int[] move = moves[i];
			int r = move[0], c = move[1];
			if (i % 2 == 0) {
				if (++row[r] == 3 || ++col[c] == 3 || r == c && ++diagonal[0] == 3 || r == 2 - c && ++diagonal[1] == 3) {
					return "A";
				}
			} else {
				if (--row[r] == -3 || --col[c] == -3 || r == c && --diagonal[0] == -3 || r == 2 - c && --diagonal[1] == -3) {
					return "B";
				}
			}
		}
		return n == 9 ? "Draw" : "Pending";
	}
}
