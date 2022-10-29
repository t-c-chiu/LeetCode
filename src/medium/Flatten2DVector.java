package medium;

public class Flatten2DVector {
	
	public static void main(String[] args) {
		Vector2D vector2D = new Vector2D(new int[][]{{1, 2}, {3}, {4}});
		vector2D.next();    // return 1
		vector2D.next();    // return 2
		vector2D.next();    // return 3
		vector2D.hasNext(); // return True
		vector2D.hasNext(); // return True
		vector2D.next();    // return 4
		vector2D.hasNext(); // return False
	}
	
	static class Vector2D {
		
		int row = 0;
		int col = 0;
		int[][] vec;
		
		public Vector2D(int[][] vec) {
			this.vec = vec;
		}
		
		public int next() {
			if (hasNext()) {
				return vec[row][col++];
			} else {
				return -1;
			}
		}
		
		public boolean hasNext() {
			while (row < vec.length && col == vec[row].length) {
				row++;
				col = 0;
			}
			return row < vec.length;
		}
	}
	
}
