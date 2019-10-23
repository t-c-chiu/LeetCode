package medium;

public class BattleshipsInABoard {
	
	public static void main(String[] args) {
		BattleshipsInABoard test = new BattleshipsInABoard();
		final int res = test.countBattleships(new char[][]{
				{'X', '.', '.', 'X'},
				{'.', '.', '.', 'X'},
				{'.', '.', '.', 'X'}
		});
		System.out.println(res);
	}
	
	public int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.' || i > 0 && board[i - 1][j] == 'X' || j > 0 && board[i][j - 1] == 'X')
					continue;
				count++;
			}
		}
		return count;
	}

//	public int countBattleships(char[][] board) {
//		int count = 0;
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				if (board[i][j] == 'X') {
//					board[i][j] = '.';
//					for (int k = i + 1; k < board.length; k++) {
//						if (board[k][j] == 'X')
//							board[k][j] = '.';
//						else
//							break;
//					}
//					for (int k = j + 1; k < board[i].length; k++) {
//						if (board[i][k] == 'X')
//							board[i][k] = '.';
//						else
//							break;
//					}
//					count++;
//				}
//			}
//		}
//		return count;
//	}
}
